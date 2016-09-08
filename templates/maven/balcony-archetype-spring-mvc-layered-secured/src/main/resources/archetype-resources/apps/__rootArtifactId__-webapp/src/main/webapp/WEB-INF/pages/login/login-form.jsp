#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form modelAttribute="loginRequest" action="login">
  <fieldset>
    <legend>
      Please login
    </legend>
    <spring:hasBindErrors name="loginRequest">
      <c:if test="${symbol_dollar}{not empty errors.globalError}">
        <div>
          <form:errors element="span" />
        </div>
      </c:if>
    </spring:hasBindErrors>
    <spring:bind path="username">
      <div>
        ${symbol_dollar}{loginRequest.username }
        <spring:message code="m_key.page.login.placeholder.username" var="placeholderUsername" />
        <form:input path="username" placeholder="Username" />
        <form:errors element="span" path="username" />
      </div>
    </spring:bind>
    <spring:bind path="password">
      <div>
        <form:password path="password" id="input_password" placeholder="Password" />
        <form:errors element="span" path="password" />
      </div>
    </spring:bind>
    <div>
      <input type="submit" value="Login"></input>
    </div>
  </fieldset>
  

</form:form>