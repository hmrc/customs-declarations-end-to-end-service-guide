import play.sbt.PlayImport._
import sbt._

object AppDependencies {
  val bootStrapPlayVersion = "6.4.0"

  val compile = Seq(
    ws,
    "uk.gov.hmrc"                                %% "bootstrap-frontend-play-28" % bootStrapPlayVersion,
    compilerPlugin("com.github.ghik" %  "silencer-plugin"            % "1.7.9" cross CrossVersion.full),
    "com.github.ghik"                            %  "silencer-lib"               % "1.7.9" % Provided cross CrossVersion.full)

  val test = Seq(
    "com.vladsch.flexmark" % "flexmark-all" % "0.62.2" % Test,
    "org.scalatest"        %% "scalatest"   % "3.2.13"   % Test)
}
