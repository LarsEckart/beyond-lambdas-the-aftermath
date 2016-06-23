/*
 * Copyright 2016 the original author or authors.
 *
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

package beyondlambdas.slides.s8_1;

import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static beyondlambdas.slides.s8_1.Support.*;
import static java.util.stream.Collectors.toList;

public class _8_1e {

    @Test
    public void _() {

        try {
            final Stream<String> jsonDataStream = badJsonData();

            final List<User> users = jsonDataStream.parallel()
                                                   .map(Support::parseJson)
                                                   .collect(toList());

            sendCouponTo(users);
        } catch (Exception e) {
            trackError(e);
            System.out.println("No coupons sent");
        }

    }
}
