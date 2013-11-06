package methodinjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MethodInjectionConfiguration {

	@Scope("prototype")
	@Bean
	public Product product() {
		return new Product();
	}

	@Bean
	public Producer producer() {
		return new Producer() {

			@Override
			public Product produceProduct() {
				return product();
			}
		};
	}

}
