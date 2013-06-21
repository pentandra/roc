package com.pentandra.roc.core

import java.util.Date

trait CreatedOn {
  def createdOn: Date
  def createdBy: String
}
