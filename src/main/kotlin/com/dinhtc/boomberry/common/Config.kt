package com.dinhtc.boomberry.common

import jakarta.servlet.http.HttpServletRequest

fun buildImageUrl(request: HttpServletRequest, path: String?): String? {
    if (path.isNullOrBlank()) return null

    val baseUrl = "${request.scheme}://${request.serverName}:${request.serverPort}"
    return "$baseUrl/$path"
}
