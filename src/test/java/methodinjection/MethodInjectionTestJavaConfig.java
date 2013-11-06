package methodinjection;

import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = MethodInjectionConfiguration.class, inheritLocations = false)
public class MethodInjectionTestJavaConfig extends MethodInjectionTest {

}
