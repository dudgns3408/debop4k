/*
 * Copyright (c) 2016. Sunghyouk Bae <sunghyouk.bae@gmail.com>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package debop4k.data.orm.spring.boot.autoconfigure;

import debop4k.data.JdbcDrivers;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

import static org.assertj.core.api.Assertions.assertThat;


@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {JpaSpringBootApplication.class})
public class JpaAutoConfigurationTest {

  @Inject HibernateProperties hibernateProps;
  @PersistenceUnit EntityManagerFactory emf;

  @Test
  public void initializeTest() {
    assertThat(hibernateProps).isNotNull();
    assertThat(emf).isNotNull();
  }

  @Test
  public void testProperties() {
    assertThat(hibernateProps.getDialect()).isEqualTo(JdbcDrivers.DIALECT_H2);
  }
}
