package com.mercateo.eventstore.domain;

import java.util.UUID;

import org.immutables.value.Value;

import com.mercateo.eventstore.data.ReferenceData;
import com.mercateo.immutables.DataClass;

@Value.Immutable
@DataClass
public interface Reference {

    static ImmutableReference.Builder builder() {
        return ImmutableReference.builder();
    }

    static Reference of(ReferenceData referenceData) {
        return Reference.builder().id(referenceData.id()).type(referenceData.type()).build();
    }

    UUID id();

    String type();

}