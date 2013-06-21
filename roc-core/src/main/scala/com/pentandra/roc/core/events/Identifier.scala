package com.pentandra.roc.core.events

import java.util.UUID
import scala.util.control.Exception._
import java.util.regex.Pattern

trait Identifier {
  def uuid: UUID
}

abstract class IdentifierCompanion[A <: Identifier](val prefix: String) {
  def apply(uuid: UUID): A

  def generate(): A = apply(UUID.randomUUID)

  def fromString(s: String): Option[A] = s match {
    case IdentifierRegex(uuid) => catching(classOf[RuntimeException]) opt { apply(UUID.fromString(uuid)) }
    case _                     => None
  }

  implicit val IdentifierCompanionObject: IdentifierCompanion[A] = this

  private val IdentifierRegex = (Pattern.quote(prefix) + """\(([a-fA-F0-9-]{36})\)""").r
}
