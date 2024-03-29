/*
 * Copyright 2019 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package org.acme.reactive.crud.domain;

import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.quarkus.hibernate.reactive.panache.PanacheEntity;
import io.quarkus.hibernate.reactive.panache.PanacheEntityBase;
import io.smallrye.mutiny.Uni;
import jakarta.persistence.*;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

import javax.json.bind.annotation.JsonbTransient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "user_table")
public class User extends PanacheEntityBase {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
//값의 위치를 가르키는 Long타입
public Long id;


@NotNull
@Column(name = "email", length = 60, nullable = false)
public String email;

@Column(name = "password_hash", length = 60, nullable = false)
@JsonbTransient
public String password;

@Column(name = "created_date", updatable = false)
@JsonbTransient
public Instant createdDate = Instant.now();


@Roles
public String role;


}
