/*
 * Copyright (c) 2016. KESTI co, ltd
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package debop4k.core.cryptography;

import debop4k.core.AbstractCoreTest;
import debop4k.core.cryptography.digesters.*;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.collections.impl.factory.Lists;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * BinaryDigesterTest
 *
 * @author sunghyouk.bae@gmail.com
 * @since 2015. 8. 14.
 */
@Slf4j
public class ByteDigesterTest extends AbstractCoreTest {

  List<AbstractByteDigester> digesters =
      Lists.mutable.of(new MD5ByteDigester(),
                       new SHA1ByteDigester(),
                       new SHA256ByteDigester(),
                       new SHA384ByteDigester(),
                       new SHA512ByteDigester());

  @Test
  public void passwordDigest() {
    for (ByteDigester digester : digesters) {
      byte[] digested = digester.digest(sampleBytes);
      assertThat(digester.matches(sampleBytes, digested)).isTrue();
    }
  }
}