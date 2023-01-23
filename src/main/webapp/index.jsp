<%@ page import="com.esther.facebookclone.model.ThePost" %>
<%@ page import="com.esther.facebookclone.serviceDaoImpli.GetPostsFromDB" %>
<%@ page import="java.util.List" %>
<%@ page import="com.esther.facebookclone.model.TheComment" %>
<%@ page import="com.esther.facebookclone.serviceDaoImpli.CommentFromDB" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Facebook Clone</title>
    <link rel="stylesheet" href="style.css" />
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" />
</head>
<body>
<!-- header starts -->
<div class="header">
    <div class="header__left">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/51/Facebook_f_logo_%282019%29.svg
        /1200px-Facebook_f_logo_%282019%29.svg.png" alt=""/>
        <div class="header__input">
            <span class="material-icons"> search </span>
            <input type="text" placeholder="Search Facebook" />
        </div>
    </div>

    <div class="header__middle">
        <div class="header__option active">
            <span class="material-icons"> home </span>
        </div>
        <div class="header__option">
            <span class="material-icons"> flag </span>
        </div>
        <div class="header__option">
            <span class="material-icons"> subscriptions </span>
        </div>
        <div class="header__option">
            <span class="material-icons"> storefront </span>
        </div>
        <div class="header__option">
            <span class="material-icons"> supervised_user_circle </span>
        </div>
    </div>

    <div class="header__right">
        <div class="header__info">

            <h4>Esther Anierobi</h4>
        </div>
        <span class="material-icons"> logout </span>
    </div>
</div>
<!-- header ends -->

<!-- main body starts -->
<div class="main__body">
    <!-- sidebar starts -->
    <div class="sidebar">
        <div class="sidebarRow">
            <h4>Esther Anierobi</h4>
        </div>

        <div class="sidebarRow">
            <span class="material-icons"> local_hospital </span>
            <h4>Medics</h4>
        </div>

        <div class="sidebarRow">
            <span class="material-icons"> emoji_flags </span>
            <h4>Pages</h4>
        </div>

        <div class="sidebarRow">
            <span class="material-icons"> people </span>
            <h4>People</h4>
        </div>

        <div class="sidebarRow">
            <span class="material-icons"> chat </span>
            <h4>Messenger</h4>
        </div>

        <div class="sidebarRow">
            <span class="material-icons"> storefront </span>
            <h4>Marketplace</h4>
        </div>

        <div class="sidebarRow">
            <span class="material-icons"> video_library </span>
            <h4>Videos</h4>
        </div>

        <div class="sidebarRow">
            <span class="material-icons"> expand_more </span>
            <h4>More</h4>
        </div>
    </div>
    <!-- sidebar ends -->

    <!-- feed starts -->
    <div class="feed">
        <div class="storyReel">

            <!-- story starts -->
            <div style="
                      background-image: url('https://images.unsplash.com/photo-1527082395-e939b847da0d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80');
                    " class="story">

            </div>
            <!-- story ends -->

            <!-- story starts -->
            <div style="
                      background-image: url('https://cellularnews.com/wp-content/uploads/2020/04/Delete-photo-337x600.jpg');
                    " class="story">

            </div>
            <!-- story ends -->

            <!-- story starts -->
            <div
                    style="
                      background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTBHC2s4NFdzXEsVzvBPGjkrSePQa-8XFuNtQ&usqp=CAU');
                    "
                    class="story"
            >

            </div>
            <!-- story ends -->

            <!-- story starts -->
            <div style="
                      background-image: url('https://images.unsplash.com/photo-1527082395-e939b847da0d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80');
                    " class="story">

            </div>
            <!-- story ends -->

            <!-- story starts -->
            <div style="
                      background-image: url('https://cellularnews.com/wp-content/uploads/2020/04/Delete-photo-337x600.jpg');
                    " class="story">

            </div>
            <!-- story ends -->

            <!-- story starts -->
            <div style="
                      background-image: url('https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcTBHC2s4NFdzXEsVzvBPGjkrSePQa-8XFuNtQ&usqp=CAU');
                    " class="story">

            </div>
            <!-- story ends -->
        </div>

        <!-- message sender starts -->
        <div class="messageSender">
            <div class="messageSender__top">


                <form action="index" method="post" >
                    <input name="post_content" type="text" class="messageSender__input" placeholder="What's on your mind?"  />
                    <div class="messageSender__option">
                        <span style="color: orange" class="material-icons"> send </span>
                    </div>
                </form>

                <input type="hidden" name="userOB" value="<%=request.getSession().getAttribute("loggedUser")%>">
                <input type="hidden" name="userId" value="<%=request.getSession().getAttribute("user_id")%>">


                <%--                <%session.invalidate();%>--%>
            </div>

        </div>
        <!-- message sender ends -->

        <!-- post starts -->
        <div class="post">

        </div>
        <!-- post ends -->




        <%List<ThePost> postList = GetPostsFromDB.getPostsFromDB();
            for (ThePost post : postList) {
                post.getPost_content();
                post.getFirstname();
                post.getLastname();
                //post.getTime();
        %>

        <!-- post starts -->
        <div class="post">
            <div class="post__top">

                <div class="post__topInfo">
                    <h3> <%=post.getFirstname()%> <%=post.getLastname()%> </h3>
                    <p><%=post.getTime()%> </p>
                </div>


            </div>

            <div class="post__bottom">
                <p><%=post.getPost_content()%></p>
            </div>



            <div class="post__options">
                <div class="post__option" >
                    <span class="material-icons"> thumb_up </span>
                    <p>Like <span>0</span> </p>

                </div>

                <div>
                    <form action="comment" method="post" >
                        <input name="comment_content" type="text"  placeholder="Comment here">
                        <div class="post__option">

                            <span style="color: orangered" class="material-icons"> chat_bubble_outline </span>
                            <p>Comment</p>
                        </div>
                        <input type="hidden" name="userOB" value="<%=request.getSession().getAttribute("loggedUser")%>">
                        <input type="hidden" name="userId" value="<%=request.getSession().getAttribute("user_id")%>">
                        <input type="hidden" name="postId" value="<%=post.getPost_id()%>">
                    </form>
                </div>

                <div class="post__option">
                    <span class="material-icons"> edit </span>
                    <p>Edit</p>
                </div>

                <div class="post__option">
                    <span class="material-icons"> delete </span>
                    <p>Delete</p>
                </div>
            </div>
            <hr>

            <% List<TheComment> commentList = CommentFromDB.getCommentsFromDB(post.getPost_id());
                for (TheComment comment : commentList) {
                    comment.getComment_content();
            %>

            <div class="post__bottom">
                <p><%=comment.getComment_content()%></p>
            </div>
            <% } %>
        </div>

        <% } %>

        <!-- post ends -->

        <!-- post starts -->

        <!-- post ends -->
    </div>
    <!-- feed ends -->

    <div style="flex: 0.33" class="widgets">
        <div
                class="fb-page"
                data-href="https://www.facebook.com/facebook"
                data-tabs="timeline"
                data-width="500"
                data-height="1000"
                data-small-header="false"
                data-adapt-container-width="true"
                data-hide-cover="false"
                data-show-facepile="true">
            </blockquote>
        </div>
    </div>
</div>
<!-- main body ends -->
<div id="fb-root"></div>
</body>
</html>