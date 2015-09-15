package edu.sample.spring.rest.config;

import edu.sample.spring.rest.model.Member;
import edu.sample.spring.rest.model.Members;
import edu.sample.spring.rest.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.xml.MarshallingView;

/**
 * Created by Kafeilab on 9/15/15.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "edu.sample.spring.rest.controller")
public class CourtRestConfiguration {

    /*
     * The membertemplate view is defined as a MarshallingView
     * which, here, rederer using a marshaller
     */

    @Bean
    public View membertemplate() {
        return new MarshallingView(jaxb2Marshaller());
    }

    /*
     * Spring provides the following marshaller:
     *
     * Jaxb2Marshaller, CastorMarshaller, JibxMarshaller,
     * XmlBeansMarshaller, and XStreamMarshaller
     */
    @Bean
    public Marshaller jaxb2Marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();

        // Configure classToBeBound or contextPath
        marshaller.setClassesToBeBound(Member.class, Members.class);
        return marshaller;
    }

    @Bean
    public ViewResolver viewResolver() {
        return new BeanNameViewResolver();
    }

    @Bean
    public MemberService memberService() {
        return new MemberService();
    }

}
