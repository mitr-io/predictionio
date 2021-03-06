/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package org.apache.predictionio.controller

import org.apache.predictionio.core.BaseEngine

import scala.language.implicitConversions

/** If you intend to let PredictionIO create workflow and deploy serving
  * automatically, you will need to implement an object that extends this class
  * and return an [[Engine]].
  *
  * @group Engine
  */
abstract class EngineFactory {
  /** Creates an instance of an [[Engine]]. */
  def apply(): BaseEngine[_, _, _, _]

  /** Override this method to programmatically return engine parameters. */
  def engineParams(key: String): EngineParams = EngineParams()
}

/** DEPRECATED. Use [[EngineFactory]] instead.
  *
  * @group Engine
  */
@deprecated("Use EngineFactory instead.", "0.9.2")
trait IEngineFactory extends EngineFactory
