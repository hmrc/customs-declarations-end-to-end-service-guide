/*
 * Copyright 2023 HM Revenue & Customs
 *
 */

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import scala.language.postfixOps
import sys.process._

class BuildSpec extends AnyWordSpec with Matchers {
  "Building the content" should {
    "produce static files" in {
      val result = "bundle install" #&& Process("bundle exec middleman build --build-dir=public/ --clean", None) !

      result shouldBe 0
    }
  }
}
