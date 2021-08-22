package com.getir.readingisgood.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@EnableMongoAuditing
@Configuration
@PropertySource("classpath:application.properties")
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Value("${mongodb.host}")
	String mongodb_host;

	@Value("${mongodb.port}")
	int mongodb_port;

	@Value("${mongodb.database}")
	String mongodb_databasename;

	@Override
	protected String getDatabaseName() {
		return this.mongodb_databasename;
	}

	@Override
	public MongoClient mongoClient() {
		ConnectionString connectionString = new ConnectionString("mongodb://"+mongodb_host+":"+mongodb_port+"/"+mongodb_databasename);
		MongoClientSettings mongoClientSettings = MongoClientSettings.builder().applyConnectionString(connectionString)
				.build();

		return MongoClients.create(mongoClientSettings);
	}

	@Override
	public Collection getMappingBasePackages() {
		return Collections.singleton("com.getir");
	}
}
