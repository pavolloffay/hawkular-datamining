/*
 * Copyright 2015-2016 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.hawkular.datamining.forecast;

import java.io.Serializable;

/**
 * Represents point at specific time
 *
 * @author Pavol Loffay
 */
public class DataPoint implements Serializable, Comparable<DataPoint> {

    private Long timestamp;
    private Double value;


    public DataPoint() {
    }

    public DataPoint(Double value, Long timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public Double getValue() {
        return value;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " { value = " + value + " , timestamp=" + timestamp + " }";
    }

    @Override
    public int compareTo(DataPoint dataPoint) {
        if (this.getTimestamp() < dataPoint.getTimestamp()) {
            return -1;
        } else if (this.getTimestamp() > dataPoint.getTimestamp()) {
            return 1;
        }

        return 0;
    }
}
