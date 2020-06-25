import play.sbt.PlayImport._
import sbt._

object AppDependencies {
  val bootStrapPlayVersion = "1.10.0"

  val compile = Seq(
    ws,
    "uk.gov.hmrc" %% "bootstrap-play-26" % bootStrapPlayVersion)

  val test = Seq(
    "com.vladsch.flexmark" % "flexmark-all" % "0.35.10" % Test,
    "org.scalatest" %% "scalatest" % "3.2.0" % Test)
}
