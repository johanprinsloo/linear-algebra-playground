SBT_OPTS="-Xms512M -Xmx1536M -Xss1M -XX:+CMSClassUnloadingEnabled  -Dscala.color"
java $SBT_OPTS -jar `dirname $0`/sbt-launch.jar "$@"
