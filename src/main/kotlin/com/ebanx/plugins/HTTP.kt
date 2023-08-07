package com.ebanx.plugins

import io.ktor.server.application.*
import io.ktor.server.plugins.compression.*
import io.ktor.server.plugins.defaultheaders.*
import io.ktor.server.plugins.forwardedheaders.*

fun Application.configureHTTP() {
  install(Compression) {
    gzip {
      priority = 1.0
    }
    deflate {
      priority = 10.0
      minimumSize(1024) // condition
    }
  }
  install(DefaultHeaders)
  install(ForwardedHeaders) // WARNING: for security, do not include this if not behind a reverse proxy
  install(XForwardedHeaders) // WARNING: for security, do not include this if not behind a reverse proxy
}