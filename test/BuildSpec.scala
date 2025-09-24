/*
 * Copyright 2023 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import java.io.{File, PrintWriter}
import scala.io.{BufferedSource, Source}
import scala.language.postfixOps
import sys.process._

class BuildSpec extends AnyWordSpec with Matchers {

  private def readFileContent(filePath: String): String = {
    val file: File             = new File(filePath)
    val source: BufferedSource = Source.fromFile(file, "UTF-8")
    try source.getLines().mkString("\n")
    finally source.close()

  }

  private def updateFileContent(filePath: String, newContent: String): Unit = {
    val file: File               = new File(filePath)
    val printWriter: PrintWriter = new PrintWriter(file, "UTF-8")
    try printWriter.write(newContent)
    finally printWriter.close()
  }

  "Building the content" should {
    "produce static files" in {
      val result: Int = "bundle install" #&& Process(
        "bundle exec middleman build --build-dir=public/ --clean",
        None
      ) !

      result shouldBe 0
    }
  }

  "Modifying the content" should {
    "update all assets urls in manifest.css to start with the base route" in {
      val filePath: String        = "public/stylesheets/manifest.css"
      val originalContent: String = readFileContent(filePath)

      updateFileContent(
        filePath,
        originalContent.replace("url(\"", "url(\"/guides/customs-declarations-end-to-end-service-guide")
      )

      val updatedContent: String = readFileContent(filePath)

      updatedContent should not be originalContent

      updatedContent should include("url(\"/guides/customs-declarations-end-to-end-service-guide")
    }
  }
}
