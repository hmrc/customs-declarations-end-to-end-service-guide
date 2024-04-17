import play.sbt.PlayImport.*
import sbt.*

object AppDependencies {
  val bootStrapVersion = "8.5.0"

  val compile: Seq[ModuleID] = Seq(
    ws,
    "uk.gov.hmrc" %% "bootstrap-frontend-play-30" % bootStrapVersion,
  )

  val test: Seq[ModuleID] = Seq(
    "uk.gov.hmrc"          %% "bootstrap-test-play-30"  % bootStrapVersion % Test,
    "org.pegdown"          % "pegdown"                  % "1.6.0"  % Test,
    "com.vladsch.flexmark" % "flexmark-profile-pegdown" % "0.64.8" % Test,
    "org.scalatest"        %% "scalatest"               % "3.2.18" % Test
  )
}
