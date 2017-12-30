package com.niit.Collaboration_Back.dbConfig;

 
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.Collaboration_Back.model.Blog;
import com.niit.Collaboration_Back.model.Event;
import com.niit.Collaboration_Back.model.Forum;
import com.niit.Collaboration_Back.model.Users;

 

@Configuration
@ComponentScan("com.niit.Collaboration_Back")
@EnableTransactionManagement
public class HibernateConfig{

@Autowired
@Bean(name="dataSource")
public DataSource getH2DataSource()
{

DriverManagerDataSource dataSource = new DriverManagerDataSource();
dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
dataSource.setUsername("COLLABORATIVE");
dataSource.setPassword("password");

System.out.println("Data Source Created");
return dataSource;
}
private Properties getHibernateProperties() {
Properties properties = new Properties();
properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect" );
//"org.hibernate.dialect.OracleDialect"
properties.put("hibernate.hbm2ddl.auto", "update");
properties.put("hibernate.show_sql", "true");
return properties;
}

@Autowired
@Bean(name = "sessionFactory")
public SessionFactory getSessionFactory(DataSource dataSource) {
LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
sessionBuilder.addProperties(getHibernateProperties());

 
sessionBuilder.addAnnotatedClass(Users.class);
sessionBuilder.addAnnotatedClass(Blog.class);
sessionBuilder.addAnnotatedClass(Forum.class);
sessionBuilder.addAnnotatedClass(Event.class);
//sessionBuilder.scanPackages("com.niit.Collaboration_Back");
return sessionBuilder.buildSessionFactory();
}


@Autowired
@Bean(name = "transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
return transactionManager;
}



}

