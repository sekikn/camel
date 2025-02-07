/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.camel.component.jackson;

import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;

/**
 * Supported schema types for Java object serialization/deserialization
 */
public enum SchemaType {
    PROTOBUF("protobuf"),
    AVRO("avsc"),
    JSON("json");

    private static final SchemaType[] VALUES = values();

    private final String schemaType;

    SchemaType(String type) {
        this.schemaType = type;
    }

    public String type() {
        return schemaType;
    }

    public static SchemaType of(String type) {
        return Arrays.stream(VALUES)
                .filter(s -> Objects.equals(s.schemaType, type))
                .findFirst()
                .orElseGet(() -> SchemaType.valueOf(type.toUpperCase(Locale.US)));
    }
}
