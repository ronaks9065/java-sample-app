package com.prodyna.dataprotection.navigator.converter;

interface Mapper<IN, OUT> {

    OUT mapTo(IN input);

    IN mapFrom(OUT input);
}
