package org.springsource.examples.sawt.services.integration;

import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.integration.launch.JobLaunchingMessageHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springsource.examples.sawt.services.batch.BatchConfiguration;

import javax.inject.Inject;

/**
 * Simple integration configuration that also works with configuration previously
 * defined in the batch solution.
 *
 * @author Josh Long
 */
@Configuration
@Import(BatchConfiguration.class)
@ImportResource("/org/springsource/examples/sawt/services/integration/context.xml")
public class IntegrationConfiguration {

    @Inject
    private JobLauncher jobLauncher;

    @Bean
    public JobLaunchingMessageHandler jobMessageHandler() throws Exception {
        return new JobLaunchingMessageHandler(jobLauncher);
    }

}
