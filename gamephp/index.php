
<?php
        
          
          include "config.php";
          include "rating.php";
          $email=$_SESSION['userid'];
          $result = mysqli_query($connection, 'SELECT AVG(ratedIndex) AS rating_avg FROM stars'); 
          $row = mysqli_fetch_assoc($result); 
          $avg = $row['rating_avg'];
          $avgRound = round($avg);
          
          $total=mysqli_query($connection, 'SELECT count(ratedIndex) AS rating_count FROM stars');
          $row=mysqli_fetch_assoc($total);
          $totalRate=$row['rating_count'];

          $total=mysqli_query($connection, 'SELECT count(ratedIndex) AS rating_count FROM stars where ratedIndex=5');
          $row=mysqli_fetch_assoc($total);
          $fiveRate=$row['rating_count']; 
          $barfive=($fiveRate/$totalRate)*100;         

          $total=mysqli_query($connection, 'SELECT count(ratedIndex) AS rating_count FROM stars where ratedIndex=4');
          $row=mysqli_fetch_assoc($total);
          $fourRate=$row['rating_count'];
          $barfour=($fourRate/$totalRate)*100;

          $total=mysqli_query($connection, 'SELECT count(ratedIndex) AS rating_count FROM stars where ratedIndex=3');
          $row=mysqli_fetch_assoc($total);
          $threeRate=$row['rating_count'];
          $barthree=($threeRate/$totalRate)*100;
          
          $total=mysqli_query($connection, 'SELECT count(ratedIndex) AS rating_count FROM stars where ratedIndex=2');
          $row=mysqli_fetch_assoc($total);
          $twoRate=$row['rating_count'];
          $bartwo=($twoRate/$totalRate)*100;

          
          $total=mysqli_query($connection, 'SELECT count(ratedIndex) AS rating_count FROM stars where ratedIndex=1');
          $row=mysqli_fetch_assoc($total);
          $oneRate=$row['rating_count'];
          $barone=($oneRate/$totalRate)*100;

          $lastIndex=mysqli_query($connection, "SELECT `ratedIndex` FROM `stars` WHERE `email`='$email'");
          $row=mysqli_fetch_assoc($lastIndex);
          $yettoUpdate=$row['ratedIndex'];
          
?>











<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Link Swiper's CSS -->
    <link
      rel="stylesheet"
      href="https://unpkg.com/swiper/swiper-bundle.min.css"
    />
    <meta
      name="google-signin-client_id"
      content="1020489281435-rstf39fjr9eils12dru1dhfosd0k3fuc.apps.googleusercontent.com"
    />
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Game Play</title>

    <link
      rel="stylesheet"
      href="https://unpkg.com/swiper/swiper-bundle.min.css"
    />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
    />
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/typed.js/2.0.11/typed.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/waypoints/4.0.1/jquery.waypoints.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/owl.carousel.min.js"></script>
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css"
    />
    <link rel="stylesheet" href="style.css" />
    <!-- Demo styles -->
    <style>
      .swiper-container {
        width: 100%;
        height: 100%;
      }

      .swiper-slide {
        text-align: center;
        font-size: 18px;
        background: #fff;

        /* Center slide text vertically */
        display: -webkit-box;
        display: -ms-flexbox;
        display: -webkit-flex;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        -webkit-justify-content: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        -webkit-align-items: center;
        align-items: center;
      }

      @media (max-width: 760px) {
        .swiper-button-next {
          right: 20px;
          transform: rotate(90deg);
        }

        .swiper-button-prev {
          left: 20px;
          transform: rotate(90deg);
        }
      }

    </style>
  </head>

  <body>
    <div class="scroll-up-btn">
      <i class="fas fa-angle-up"></i>
    </div>
    <nav class="navbar" style="background-color: #515151">
      <div class="max-width">
        <div class="logo" style="margin: 0px">
          <a href="#"
            ><i class="fa fa-gamepad" aria-hidden="true"></i> Game<span
              >play.</span
            ></a
          >
        </div>
        <ul class="menu">
          <li><a href="#game" class="menu-btn">Game</a></li>
          <li><a href="#comment" class="menu-btn">Contact</a></li>
          <li>
            <a
              href="javaScript:void(0)"
              onclick="signOut();"
              class="menu-btn"
              id="logout"
              >Logout</a
            >
          </li>
        </ul>
        <div class="menu-btn">
          <i class="fas fa-bars"></i>
        </div>
      </div>
    </nav>
    <section class="game" id="game">
      <div class="max-width">
        <h2 class="title">Fun Games</h2>
        <!-- Swiper -->
        <div class="swiper-container">
          <div class="swiper-wrapper">
            <div class="swiper-slide">
              <div class="container">
                <!--decsription-->
                <div class="box1">
                  <div class="image">
                    <img src="images/rock.png" class="model" />

                    <div class="titletext">
                      <h1>Rock Paper Scissor<br /></h1>
                    </div>
                    <div class="rating">
                      <span class="heading">User Rating</span>

                      <p><strong id="avg"></strong> average based on <strong id="totalrate"></strong> reviews.</p>

                      <div class="row">
                        <div class="side">
                          <div>5 star</div>
                        </div>
                        <div class="middle">
                          <div class="bar-container">
                            <div class="bar-5"></div>
                          </div>
                        </div>
                        <div class="side right">
                          <div id="fivestar"></div>
                        </div>
                        <div class="side">
                          <div>4 star</div>
                        </div>
                        <div class="middle">
                          <div class="bar-container">
                            <div class="bar-4"></div>
                          </div>
                        </div>
                        <div class="side right">
                          <div id="fourstar"></div>
                        </div>
                        <div class="side">
                          <div>3 star</div>
                        </div>
                        <div class="middle">
                          <div class="bar-container">
                            <div class="bar-3"></div>
                          </div>
                        </div>
                        <div class="side right">
                          <div id="threestar"></div>
                        </div>
                        <div class="side">
                          <div>2 star</div>
                        </div>
                        <div class="middle">
                          <div class="bar-container">
                            <div class="bar-2"></div>
                          </div>
                        </div>
                        <div class="side right">
                          <div id="twostar"></div>
                        </div>
                        <div class="side">
                          <div>1 star</div>
                        </div>
                        <div class="middle">
                          <div class="bar-container">
                            <div class="bar-1"></div>
                          </div>
                        </div>
                        <div class="side right">
                          <div id="onestar"></div>
                        </div>
                      </div>
                    </div>
                  </div>
                  <div class="details">
                    <div class="center">
                      <h1>
                        Description<br /><span>-developed by Raguram</span>
                      </h1>
                      <p>
                        Rock paper Scissor was an intresting fun game.It was an
                        one-to-computer game.
                      </p>

                      <div class="wrapper"></div>
                      <a
                        href="https://rock-paper-scissor-19a11.web.app/"
                        class="video video-popup mfp-iframe"
                        data-lity
                        ><i class="fas fa-play"></i> Play!</a
                      >
                      <button class="review" id="rev" onclick="validate()">
                        review
                      </button>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="swiper-button-next"></div>
          <div class="swiper-button-prev"></div>
        </div>
      </div>
      <div class="loginmodal" id="loginmodal">
        <div class="modal-content">
          <span class="close-button">×</span>
          <div class="g-signin2" id="g-signin2" data-onsuccess="onSignIn"></div>
        </div>
      </div>
      <div class="ratingmodal" id="ratingmodal">
        <div class="modal-content">
          <span class="close-button">×</span>
          <div class="rate">
            <h2>Rate Us</h2>
            <div align="center">
              <i class="fa fa-star fa-2x" data-index="0"></i>
              <i class="fa fa-star fa-2x" data-index="1"></i>
              <i class="fa fa-star fa-2x" data-index="2"></i>
              <i class="fa fa-star fa-2x" data-index="3"></i>
              <i class="fa fa-star fa-2x" data-index="4"></i>
              <br>
              <?php echo $yettoUpdate?>
            </div>
            <br />
          </div>
        </div>
      </div>
    </section>

    <!-- contact section start -->
    <section class="contact" id="contact">
      <div class="max-width">
        <h2 class="title">Contact me</h2>
        <div class="contact-content">
          <div class="column left">
            <div class="text">Get in Touch</div>
            <p>You can get me through any social-media as mentioned below:</p>
            <div class="icons">
              <div class="row">
                <i class="fas fa-user"></i>
                <div class="info">
                  <div class="head">Name</div>
                  <div class="sub-title">Raguram Sundaravadivel</div>
                </div>
              </div>
              <div class="row">
                <i class="fas fa-map-marker-alt"></i>
                <div class="info">
                  <div class="head">Address</div>
                  <div class="sub-title">Kallaikurichi, Tamil Nadu</div>
                </div>
              </div>
              <div class="row">
                <i class="fas fa-envelope"></i>
                <div class="info">
                  <div class="head">Email</div>
                  <div class="sub-title">ragurams2000@gmail.com</div>
                </div>
              </div>
            </div>
          </div>
          <div class="column right">
            <div class="text"></div>
          </div>
        </div>
      </div>
    </section>

    <!-- footer section start -->
    <footer>
      <div class="rounded-social-buttons">
        <a
          class="social-button facebook"
          href="https://m.facebook.com/randy.ragu.714"
          target="_blank"
          ><i class="fab fa-facebook-f"></i
        ></a>
        <a
          class="social-button twitter"
          href="https://twitter.com/RaguRazz?s=09"
          target="_blank"
          ><i class="fab fa-twitter"></i
        ></a>
        <a
          class="social-button linkedin"
          href="https://www.linkedin.com/in/ragu-ram-252526194"
          target="_blank"
          ><i class="fab fa-linkedin"></i
        ></a>
        <a
          class="social-button instagram"
          href="https://www.instagram.com/i_m_ragu_/"
          target="_blank"
          ><i class="fab fa-instagram"></i
        ></a>
      </div>
      <span
        >Created By <a href="#">Raguram Sundaravadivel</a> |
        <span class="far fa-copyright"></span> 2021 All rights reserved.</span
      >
    </footer>
    <!-- Swiper JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <!---google script-->
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <!-- Initialize Swiper -->
    <script src="script.js"></script>
    <!--Rating Script-->
    <script>
      function validate() {
        $(".logout").hide();
        const rmodal = document.querySelector(".ratingmodal");
        const modal = document.querySelector(".loginmodal");
        const trigger = document.getElementById("rev");
        const closeButton = document.querySelector(".close-button");
        function toggleModal() {
          modal.classList.toggle("show-modal");
        }

        function windowOnClick(event) {
          if (event.target === modal) {
            toggleModal();
          }
        }

        closeButton.addEventListener("click", toggleModal);
        function toggleModal1() {
          rmodal.classList.toggle("show-modal");
        }

        function windowOnClick(event) {
          if (event.target === rmodal) {
            toggleModal1();
          }
        }
        closeButton.addEventListener("click", toggleModal);
        window.addEventListener("click", windowOnClick);
        //developers.google.com/identity/sign-in/web/reference#googleauthissignedinget
        https: var isSignedIn = gapi.auth2.getAuthInstance().isSignedIn.get();
        if (isSignedIn == false) {
          trigger.addEventListener("click", toggleModal);
        } else {
          trigger.addEventListener("click", toggleModal1);

          console.log("Already Logged in");
        }
      }

      //info from google sign in
      function onSignIn(googleUser) {
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Do not send to your backend! Use an ID token instead.
        console.log("Name: " + profile.getName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail()); // This is null if the 'email' scope is not present.
        //storing user deatils
        var googleTockenId = profile.getId();
        var name = profile.getName();
        var email = profile.getEmail();
        var profile = profile.getImageUrl();
        rating(email);
        saveUserData(googleTockenId, name, email, profile); // save data to our database for reference
        $("#loginmodal").hide("fast");
        $(".logout").show("fast");
      }

      //signout
      function signOut() {
        var auth2 = gapi.auth2.getAuthInstance();
        auth2.signOut().then(function () {
          console.log("User signed out.");
        });
      }

      //savedatabase

      function saveUserData(googleTockenId, name, email, profile) {
        $.post(
          "script.php",
          {
            authProvider: "Google",
            googleTockenId: googleTockenId,
            name: name,
            email: email,
            profile: profile,
          },
          function (response) {
            var data = response.split("^");
            if (data[1] == "loggedIn") {
              console.log("logged in");
              $("#loaderIcon").hide("fast");
              $("#g-signin2").hide("fast");
              $("#profileLabel").attr("src", profile);
              $("#nameLabel").html(name);
              $(".emailLabel").html(email);
              $("#googleIdLabel").html(googleTockenId);
            }
          }
        );
      }
      function rating(email){
        setStars('<?php echo $yettoUpdate ?>'-1);
         var ratedIndex=-1;
          $('.fa-star').on('click', function () {
               ratedIndex = parseInt($(this).data('index'));
               localStorage.setItem('ratedIndex', ratedIndex);
               saveToTheDB();
              });
          $(".fa-star").mouseover(function () {
           resetStarColors();
            var currentIndex = parseInt($(this).data("index"));
          setStars(currentIndex);
        });

        $(".fa-star").mouseleave(function () {
          resetStarColors();

          if (ratedIndex != -1) setStars(ratedIndex);
        });
      function saveToTheDB(){
        console.log(ratedIndex);
        window.location.href="rating.php? email="+email+"&ratedIndex="+ratedIndex;
        
        
        // $.ajax({
        //        url: "/rating.php",
        //        method: "POST",
        //        dataType: 'json',
        //        data: {
        //            save: 1,
        //            uID: userid,
        //            ratedIndex: ratedIndex
        //        }, success: function () {
        //             alert("Rated Successfully");
        //             $("#ratingmodal").hide('fast');
        //        }
        //     });
      }
      function setStars(max) {//4
            for (var i=0; i <= max; i++)
                $('.fa-star:eq('+i+')').css('color', 'green');
        }
      function resetStarColors() {
        $(".fa-star").css("color", "black");
      }

    }
    document.getElementById('avg').textContent='<?php echo $avgRound?>';
    document.getElementById('totalrate').textContent='<?php echo $totalRate?>';
    document.getElementById('fivestar').textContent='<?php echo $fiveRate?>';
    document.getElementById('fourstar').textContent='<?php echo $fourRate?>';
    document.getElementById('threestar').textContent='<?php echo $threeRate?>';
    document.getElementById('twostar').textContent='<?php echo $twoRate?>';
    document.getElementById('onestar').textContent='<?php echo $oneRate?>';
    </script>
  </body>
</html>



