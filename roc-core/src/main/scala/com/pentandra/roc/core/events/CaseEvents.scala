package com.pentandra.roc.core.events

import java.util.UUID

/**
 * A strongly typed identifier for cases.
 */
case class CaseId(uuid: UUID) extends Identifier
object CaseId extends IdentifierCompanion[CaseId]("CaseId")

/**
  * Case events.
  */
sealed trait CaseEvent extends DomainEvent {
  def caseId: CaseId
}

case class CaseCreated(caseId: CaseId) extends CaseEvent
