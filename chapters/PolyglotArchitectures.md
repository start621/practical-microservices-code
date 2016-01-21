# Polyglot Architectures

One of the most interesting thing about microservice architecture is that it opens up the possibility for using different
languages or different services. This is a refreshing change from traditional monolith architectures where you pick a language
and pretty much have to use that for everything. 

While there is nothing to stop you choosing different languages for different parts of your system, it's worth remembering that supporting multiple languages introduces some significant problems to most organisations. Although a good developer should be happy enough learning new languages quickly, in reality this isn't always the case, especially in larger enterprise teams. Some of the problems with using multiple languages in a system include

1. Teams have to learn multiple languages
2. Infrastructure teams and tools (CI etc) have to support multiple build tools
3. Shared code (custom libraries) may need to be duplicated for each new language
4. Having multiple languages can make hiring for your team more difficult

A sane approach is to pick one platform to build upon (for instance the JVM) and only introduce new
languages if they are really essential to solving your problem. The JVM is a nice platform in this regard because, in many cases, libraries written in Java can be shared with Scala, Groovy or Clojure services.
