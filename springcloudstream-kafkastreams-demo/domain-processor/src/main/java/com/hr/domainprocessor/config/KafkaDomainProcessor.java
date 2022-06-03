package com.hr.domainprocessor.config;

import java.util.function.Function;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hr.domain.common.Domain;



/**
 * Ideally, the active/inactive domains are identified from the 'isDead' flag but in our example, we don't have any domain with isDead as 'true'.
 * Hence we are using a different logic for this segregation.
 * 
 * Custom Logic: A domain is considered as ACTIVE if the country is not-null
 * 
 * @author himanshubhusan.rath
 *
 */
@Configuration
public class KafkaDomainProcessor {

	/**
	 * 
	 * Filter the active domains and publish those to one topic. 
	 * 
	 * @return
	 */
	@Bean
	public Function<KStream<String, Domain>, KStream<String, Domain>> activeDomainProcessor()
	{
		return kstream -> kstream.filter((key, domain)-> {
			if(null!=domain.getCountry())
			{
				System.out.println("Active Domain >> "+domain.getDomain());
			}
			
			return null!=domain.getCountry();
		});
	}
	
	/**
	 * Filter the inactive domains and publish those to another topic. 
	 * 
	 * @return
	 */
	@Bean
	public Function<KStream<String, Domain>, KStream<String, Domain>> inactiveDomainProcessor()
	{
		return kstream -> kstream.filter((key, domain)-> {
			if(null==domain.getCountry())
			{
				System.out.println("Inactive Domain >> "+domain.getDomain());
			}
			
			return null==domain.getCountry();
		});
	}
}
