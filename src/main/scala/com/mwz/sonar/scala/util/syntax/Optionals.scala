/*
 * Sonar Scala Plugin
 * Copyright (C) 2018 All contributors
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 */
package com.mwz.sonar.scala
package util
package syntax

import java.util.Optional

/**
 * Scala.Option <-> Java.Optional conversions.
 */
object Optionals {

  /**
   * Transform Scala Option to a Java Optional.
   */
  implicit final class OptionOps[T >: Null](val opt: Option[T]) extends AnyVal {
    def toOptional: Optional[T] = Optional.ofNullable(opt.orNull)
  }

  /**
   * Transform Java Optional to a Scala Option.
   */
  implicit final class OptionalOps[T](val opt: Optional[T]) extends AnyVal {
    def toOption: Option[T] = opt.map[Option[T]](Some(_)).orElse(None)
  }
}