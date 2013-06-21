/*
 * Copyright 2013 Pentandra Research Solutions, Inc.
 *
 * This file is part of roc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.pentandra.roc.core

/**
 * An element of research.
 *
 * Research is made up of elements that flow through the phases of research.
 *
 */
abstract class Element {
}

/**
 * A research input.
 */
trait Input {}

/**
 * A research output.
 */
trait Output {}

/**
 * A research question.
 */
abstract class Question extends Element

/**
 * A source is a container of information.
 *
 * A source could be a research paper in a repository, a doi, a citation,
 * an image or other file, a URL, a book, an experiment, a workflow,
 * or anything that could be retrieved or replicated by someone at a
 * later point in time. To be useful, it must contain information.
 */
abstract class Source extends Element

/**
 * Information is interpreted data.
 */
abstract class Information extends Element

/**
 * A possible answer to a research question.
 */
abstract class Evidence extends Element

/**
 * A research conclusion.
 */
abstract class Conclusion extends Element