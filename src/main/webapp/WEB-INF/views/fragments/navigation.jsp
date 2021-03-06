<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <a class="navbar-brand" href="/">Simple StackOverflow</a>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="/questions">Questions</a>
            </li>
            <c:if test="${not empty sessionScope.currentUser.username}">
                <li class="nav-item">
                    <a class="nav-link" href="/profile">My Profile</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/logout.do">Logout</a>
                </li>
            </c:if>
            <c:if test="${empty sessionScope.currentUser.username}">
                <li class="nav-item">
                    <a class="nav-link" href="/register">Register</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">Login</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>