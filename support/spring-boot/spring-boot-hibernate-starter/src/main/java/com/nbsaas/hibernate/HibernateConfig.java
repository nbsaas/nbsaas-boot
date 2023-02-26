package com.nbsaas.hibernate;


import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.List;

@Configuration
public class HibernateConfig {

    @Bean
    public HibernateProperties properties() {
        return new HibernateProperties();
    }


    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        System.out.println("init ... HibernateTransactionManager");
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    LocalSessionFactoryBean initSessionFactory(DataSource dataSource, HibernateProperties hibernateProperties) {
        System.out.println(hibernateProperties);
        System.out.println("init ... LocalSessionFactoryBean");
        LocalSessionFactoryBean bean = new LocalSessionFactoryBean();
        bean.getHibernateProperties().put("hibernate.dialect", "org.hibernate.dialect.MySQL55Dialect");
        bean.getHibernateProperties().put("hibernate.show_sql", hibernateProperties.getShow_sql());
        bean.getHibernateProperties().put("hibernate.format_sql", hibernateProperties.getFormat_sql());
        bean.getHibernateProperties().put("hibernate.hbm2ddl.auto", hibernateProperties.getHbm2ddl());
        bean.getHibernateProperties().put("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");


        bean.setDataSource(dataSource);
        List<String> scans = hibernateProperties.getEntities();
        //ServletRegistrationBean

        String[] pas = new String[scans.size()];
        scans.toArray(pas);
        bean.setPackagesToScan(pas);
        //bean.setEntityInterceptor(treeInterceptor());
        return bean;
    }
}
