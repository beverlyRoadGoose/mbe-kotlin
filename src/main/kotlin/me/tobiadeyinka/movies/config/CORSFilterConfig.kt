package me.tobiadeyinka.movies.config

import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.context.annotation.Configuration

import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus

import javax.servlet.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
class CORSFilterConfig : Filter {

    override fun destroy() {

    }

    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        var request: HttpServletRequest = servletRequest as HttpServletRequest
        var response: HttpServletResponse = servletResponse as  HttpServletResponse

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader(
            "Access-Control-Allow-Headers",
            "Origin," +
            "Accept," +
            "X-Requested-With," +
            "Content-Type," +
            "Access-Control-Request-Method," +
            "Access-Control-Request-Headers," +
            "Authorization," +
            "clientId," +
            "authToken," +
            "userId"
        )

        if (request.method == HttpMethod.OPTIONS.name) response.setStatus(HttpStatus.NO_CONTENT.value());
        else filterChain.doFilter(request, response);
    }

    override fun init(filterConfig: FilterConfig?) {

    }

}