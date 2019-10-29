/*-
 * #%L
 * camunda-bpm-feign-example
 * %%
 * Copyright (C) 2019 Camunda Services GmbH
 * %%
 * /*
 *  * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 *  * under one or more contributor license agreements. See the NOTICE file
 *  * distributed with this work for additional information regarding copyright
 *  * ownership. Camunda licenses this file to you under the Apache License,
 *  * Version 2.0; you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *  */
 * #L%
 */
package org.camunda.bpm.extension.feign.example

import com.fasterxml.jackson.databind.ObjectMapper
import feign.Logger
import org.camunda.bpm.engine.rest.dto.repository.ProcessDefinitionDto
import org.camunda.bpm.extension.feign.EnableCamundaFeign
import org.camunda.bpm.extension.feign.mixin.CamundaMixinModule
import org.camunda.bpm.extension.feign.mixin.ProcessDefinitionDtoMixin
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.scheduling.annotation.EnableScheduling

fun main() {
  SpringApplication.run(CamundaBpmFeignExampleApplication::class.java)
}

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
@EnableCamundaFeign
class CamundaBpmFeignExampleApplication {

  // full debug of feign client
  @Bean
  fun feignLoggerLevel(): Logger.Level = Logger.Level.FULL


  @Bean
  fun objectMapper(): ObjectMapper {
    val objectMapper = ObjectMapper()
    return JacksonDataFormatConfigurator
      .configureObjectMapper(objectMapper)
  }
}
