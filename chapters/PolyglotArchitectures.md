# Polyglot Architectures

One of the most interesting thing about microservice architecture is that it opens up the possibility for using different
languages or different services. This is a refreshing change from traditional monolith architectures where you pick a language
and pretty much have to use that for everything. 

While there is nothing to stop you choosing different languages for different parts of your system, it's worth remembering that
supporting multiple languages introduces some problems to most organisations. 

1. Teams have to learn multiple languages
2. Build tools have to support multiple languages
3. Shared code (custom libraries) may need to be duplicated

A sane approach is to pick one platform to build upon (for instance the JVM) and only introduce new
languages if they are really essential to solving your problem. The JVM is a nice platform in this regard because, in many cases, we can write 
libraries written in Java can be shared with Scala, Groovy or Clojure services.
