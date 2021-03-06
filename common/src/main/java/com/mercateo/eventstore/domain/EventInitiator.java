/**
 * Copyright © 2018 Mercateo AG (http://www.mercateo.com)
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
package com.mercateo.eventstore.domain;

import com.mercateo.eventstore.data.EventInitiatorData;
import com.mercateo.eventstore.data.ReferenceData;
import com.mercateo.immutables.DataClass;
import lombok.val;
import org.immutables.value.Value;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;

@Value.Immutable
@DataClass
public interface EventInitiator extends Reference {

    static ImmutableEventInitiator.Builder builder() {
        return ImmutableEventInitiator.builder();
    }

    @NotNull
    static EventInitiator of(Reference reference) {
        return EventInitiator.builder().id(reference.id()).type(reference.type()).build();
    }

    @NotNull
    static EventInitiator of(EventInitiatorData eventInitiatorData) {
        ReferenceData referenceData = eventInitiatorData.initiator() == null ? ReferenceData.of(eventInitiatorData) : eventInitiatorData.initiator();
        return EventInitiator.builder().from(referenceData).agent(eventInitiatorData.agent()).build();
    }

    @NotNull
    List<ReferenceData> agent();
}
