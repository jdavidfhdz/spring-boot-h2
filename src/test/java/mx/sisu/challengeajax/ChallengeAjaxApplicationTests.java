package mx.sisu.challengeajax;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import mx.wepi.springbooth2.SpringBootH2Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootH2Application.class)
@WebAppConfiguration
public class ChallengeAjaxApplicationTests {

	@Test
	public void contextLoads() {
	}

}
