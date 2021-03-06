/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jclouds.azurecompute.arm.domain;

import java.util.List;

import org.jclouds.javax.annotation.Nullable;
import org.jclouds.json.SerializedNames;

import com.google.auto.value.AutoValue;
import com.google.common.collect.ImmutableList;

@AutoValue
public abstract class Error {

   public abstract Details details();

   @SerializedNames({ "error" })
   public static Error create(Details details) {
      return new AutoValue_Error(details);
   }

   Error() {

   }

   @AutoValue
   public abstract static class Details {
      public abstract String code();
      public abstract String message();
      public abstract List<Details> details();

      @SerializedNames({ "code", "message", "details" })
      public static Details create(String code, String message, @Nullable List<Details> details) {
         return new AutoValue_Error_Details(code, message, details == null ? ImmutableList.<Details> of()
               : ImmutableList.copyOf(details));
      }

      Details() {

      }
   }

}
