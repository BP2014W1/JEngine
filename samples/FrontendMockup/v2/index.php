<?php include 'header.php'; ?>
      
      <div class="dashboard-wrapper">
        
        <div class="main-container">
          <div class="navbar hidden-desktop">
            <div class="navbar-inner">
              <div class="container">
                <a data-target=".navbar-responsive-collapse" data-toggle="collapse" class="btn btn-navbar">
                  <span class="icon-bar">
                  </span>
                  <span class="icon-bar">
                  </span>
                  <span class="icon-bar">
                  </span>
                </a>
                <div class="nav-collapse collapse navbar-responsive-collapse">
                  <ul class="nav">
                    <li>
                      <a href="index.html">Dashboard</a>
                    </li>
                    <li>
                      <a href="forms.html">Forms</a>
                    </li>
                    <li>
                      <a href="graphs.html">Charts</a>
                    </li>
                    <li>
                      <a href="ui-elements.html">UI Elements</a>
                    </li>
                    <li>
                      <a href="icons.html">Icons</a>
                    </li>
                    <li>
                      <a href="tables.html">Tables</a>
                    </li>
                    <li>
                      <a href="media.html">Gallery</a>
                    </li>
                    <li>
                      <a href="typography.html">Typography</a>
                    </li>
                    <li>
                      <a href="edit-profile.html">Edit Profile</a>
                    </li>
                    <li>
                      <a href="calendar.html">Calendar</a>
                    </li>
                    <li>
                      <a href="invoice.html">Invoice</a>
                    </li>
                    <li>
                      <a href="login.html">Login</a>
                    </li>
                    <li>
                      <a href="error.html">Error</a>
                    </li>
                    
                    <li>
                      <a href="help.html">Help</a>
                    </li>
                  </ul>
                </div>
                <!-- /.nav-collapse -->
              </div>
            </div>
            <!-- /navbar-inner -->
          </div>

          <div class="row-fluid">
            <div class="span2">
              <div class="widget">
                <div class="widget-header">
                  <div class="title">
                    Clients
                  </div>
                </div>
                <div class="widget-body">
                  <div class="current-statistics">
                    <div class="clients">
                      <h3>345</h3>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="span2">
              <div class="widget">
                <div class="widget-header">
                  <div class="title">
                    open Activities
                  </div>
                </div>
                <div class="widget-body">
                  <div class="current-statistics">
                    <div class="products">
                      <h3>2900</h3>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="span2">
              <div class="widget">
                <div class="widget-header">
                  <div class="title">
                    Fragments
                  </div>
                </div>
                <div class="widget-body">
                  <div class="current-statistics">
                    <div class="sales">
                      <h3>8949</h3>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="span2">
              <div class="widget">
                <div class="widget-header">
                  <div class="title">
                    Processes</div>
                </div>
                <div class="widget-body">
                  <div class="current-statistics">
                    <div class="income">
                      <h3>647</h3>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="span2">
              <div class="widget">
                <div class="widget-header">
                  <div class="title">
                    Warnings
                  </div>
                </div>
                <div class="widget-body">
                  <div class="current-statistics">
                    <div class="expenses">
                      <h3>341</h3>
                    </div>
                  </div>
                </div>
              </div>
            </div>

            <div class="span2">
              <div class="widget">
                <div class="widget-header">
                  <div class="title">
                    Errors
                  </div>
                </div>
                <div class="widget-body">
                  <div class="current-statistics">
                    <div class="signups">
                      <h3>129</h3>
                    </div>
                  </div>
                </div>
              </div>
            </div>

          </div>

          <div class="row-fluid">
            <div class="span8">
              <div class="widget">
                <div class="widget-header">
                  <div class="title">
                    <span class="fs1" aria-hidden="true" data-icon="&#xe0a2;"></span> Statistics
                  </div>
                  <div class="tools pull-right">
                    <button class="btn btn-small report_range">
                      <span> 03/29/2013 - 03/31/2013 </span> <i class="caret"></i>
                    </button>
                  </div>
                </div>
                <div class="widget-body">
                  <div id="column_chart"></div>
                </div>
              </div>
            </div>

            <div class="span4">
              <div class="widget">
                <div class="widget-header">
              
              <div class="title">
                    <span class="fs1" aria-hidden="true" data-icon="&#xe022;"></span> [Bosch SI 1]  Mitarbeiter durch IT ersetzen
                  </div>
                </div>
                <div class="widget-body">
                  <div class="todo-container">
                    <ul class="todo-list">
                      <li class="new">
                        <input type="checkbox" id="1" />
                        <label for="1">
                         [Fragment 1] Coffee with Iliyana 
                          <span class="date">
                            Mar 24
                          </span>
                        </label>
                      </li>
                      <li class="process">
                        <input type="checkbox" id="2" checked/="" />
                        <label for="2">
                         [Fragment 1] Learn Ruby
                          <span class="date">
                            Mar 19
                          </span>
                        </label>
                      </li>
                      <li class="completed">
                        <input type="checkbox" id="3" />
                        <label for="3">
                         [Fragment 3]  Be Creative
                          <span class="date">
                            Due Feb 02
                          </span>
                        </label>
                      </li>
                      <li class="process">
                        <input type="checkbox" id="4" checked="" />
                        <label for="4">
                          [Fragment 2] Order Biryani
                          <span class="date">
                            Due Feb 27
                          </span>
                        </label>
                      </li>
                      <li class="process">
                        <input type="checkbox" id="5" checked="" />
                        <label for="5">
                          [Fragment 5] Play Footall
                          <span class="date">
                            Completed Jan 29
                          </span>
                        </label>
                      </li>
                      <li class="new">
                        <input type="checkbox" id="6" />
                        <label for="6">
                          [Fragment 3] Take a photograph 
                          <span class="date">
                            Due Jan 30
                          </span>        
                        </label>
                      </li>
                    </ul>
                    <form class="no-margin" />
                      <div class="input-append">
                        <input class="span6" id="appendedInputButton" type="text" />
                        <button class="btn btn-info" type="button">Push</button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>

          </div>

          <div class="row-fluid">
            <div class="span8">
              <div class="widget">
                <div class="widget-header">
                  <div class="title">
                    <span class="fs1" aria-hidden="true" data-icon="&#xe096;"></span> Current Process
                  </div>
                </div>
                <div class="widget-body">
                 <img src="img/bpmn.png">
                </div>
              </div>
            </div>

            <div class="span4">
              <div class="widget">
                <div class="widget-header">
                            <div class="title">
                    <span class="fs1" aria-hidden="true" data-icon="&#xe022;"></span>  [Bosch SI 2]  Steigerung der strukturellen Ambidexterität
                  </div>
                </div>
                <div class="widget-body">
                  <div class="todo-container">
                    <ul class="todo-list">
                      <li class="new">
                        <input type="checkbox" id="1" />
                        <label for="1">
                         [Fragment 3]  Ambidexterität definieren
                          <span class="date">
                            Mar 24
                          </span>
                        </label>
                      </li>
                      <li class="process">
                        <input type="checkbox" id="2" />
                        <label for="2">
                         [Fragment 3] strukturell definieren
                          <span class="date">
                            Mar 19
                          </span>
                        </label>
                      </li>
                      <li class="completed">
                        <input type="checkbox" id="3" checked/=""  />
                        <label for="3">
                         [Fragment 1]  Be Creative
                          <span class="date">
                            Due Feb 02
                          </span>
                        </label>
                      </li>
                      <li class="process">
                        <input type="checkbox" id="4" />
                        <label for="4">
                          [Fragment 2] Event planen
                          <span class="date">
                            Due Feb 27
                          </span>
                        </label>
                      </li>
                      <li class="process">
                        <input type="checkbox" id="5" />
                        <label for="5">
                          [Fragment 1] Dr. Frank anrufen
                          <span class="date">
                            Completed Jan 29
                          </span>
                        </label>
                      </li>
                      <li class="new">
                        <input type="checkbox" id="6" />
                        <label for="6">
                          [Fragment 2] Team event organisieren
                          <span class="date">
                            Due Jan 30
                          </span>        
                        </label>
                      </li>
                      <li class="new">
                        <input type="checkbox" id="6" />
                        <label for="6">
                          [Fragment 4] PR Image verbessern
                          <span class="date">
                            Due Jan 30
                          </span>        
                        </label>
                      </li>
                    </ul>
                    <form class="no-margin" />
                      <div class="input-append">
                        <input class="span6" id="appendedInputButton" type="text" />
                        <button class="btn btn-info" type="button">Push</button>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
      <!--/.fluid-container-->
    </div>
    <footer>
      <p>
        &copy; BP2014W1 2015
      </p>
    </footer>
    
    <script src="js/wysiwyg/wysihtml5-0.3.0.js">
    </script>
    <script src="js/jquery.min.js">
    </script>
    <script src="js/bootstrap.js">
    </script>
    <script src="js/jquery.scrollUp.js">
    </script>

    <script src="js/wysiwyg/bootstrap-wysihtml5.js">
    </script>
    <script type="text/javascript" src="js/date-picker/date.js">
    </script>
    <script type="text/javascript" src="js/date-picker/daterangepicker.js">
    </script>

    <!-- Google Visualization JS -->
    <script type="text/javascript" src="https://www.google.com/jsapi">
    </script>

    <!-- Sparkline JS -->
    <script src="js/jquery.sparkline.js">
    </script>
    
    <!-- Tiny Scrollbar JS -->
    <script src="js/tiny-scrollbar.js">
    </script>
    
    
    
    <script type="text/javascript">
      //ScrollUp
      $(function () {
        $.scrollUp({
          scrollName: 'scrollUp', // Element ID
          topDistance: '300', // Distance from top before showing element (px)
          topSpeed: 300, // Speed back to top (ms)
          animation: 'fade', // Fade, slide, none
          animationInSpeed: 400, // Animation in speed (ms)
          animationOutSpeed: 400, // Animation out speed (ms)
          scrollText: 'Scroll to top', // Text for element
          activeOverlay: false, // Set CSS color to display scrollUp active point, e.g '#00FFFF'
        });
      });

      //wysihtml5
      $('#wysiwyg').wysihtml5();

      google.load("visualization", "1", {
        packages: ["corechart"]
      });

      $(document).ready(function () {
        drawChart1();
        drawChart2();
      })

      function drawChart1() {
        var data = google.visualization.arrayToDataTable([
          ['Week', 'open Processes', 'completed Fragments', 'Warnings', 'Errors'],
          ['Sun', 300, 1900, 900, 2900],
          ['Mon', 1170, 3860, 1220, 1564],
          ['Tue', 260, 1120, 2870, 2340],
          ['Wed', 1030, 540, 3830, 1200],
          ['Thu', 200, 700, 1700, 770],
          ['Fri', 700, 1200, 2200, 2870],
          ['Sat', 1170, 2160, 3920, 800], ]);

        var options = {
          width: 'auto',
          height: '200',
          backgroundColor: 'transparent',
          colors: ['#b5799e', '#579da9', '#e26666', '#1e825e', '#dba26b'],
          tooltip: {
            textStyle: {
              color: '#666666',
              fontSize: 11
            },
            showColorCode: true
          },
          legend: {
            textStyle: {
              color: 'black',
              fontSize: 12
            }
          },
          chartArea: {
            left: 60,
            top: 10,
            height: '80%'
          },
        };

        var chart = new google.visualization.ColumnChart(document.getElementById('column_chart'));
        chart.draw(data, options);
      }


      function drawChart2() {
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Google+', 'Facebook'],
          ['2005', 90, 30],
          ['2006', 400, 200],
          ['2007', 1050, 320],
          ['2008', 1940, 550],
          ['2009', 2910, 770],
          ['2010', 970, 1960],
          ['2011', 1660, 2520],
          ['2012', 1030, 3940]
          ]);

        var options = {
          width: 'auto',
          pointSize: 7,
          lineWidth: 1,
          height: '180',
          backgroundColor: 'transparent',
          colors: ['#b5799e', '#579da9', '#e26666', '#1e825e', '#dba26b'],
          tooltip: {
            textStyle: {
              color: '#666666',
              fontSize: 11
            },
            showColorCode: true
          },
          legend: {
            textStyle: {
              color: 'black',
              fontSize: 12
            }
          },
          chartArea: {
            left: 40,
            top: 10,
            height: "80%"
          }
        };

        var chart = new google.visualization.AreaChart(document.getElementById('area_chart'));
        chart.draw(data, options);
      }

      //Tooltip
      $('a').tooltip('hide');
      $('i').tooltip('hide');


      //Tiny Scrollbar
      $('#scrollbar').tinyscrollbar();
      $('#scrollbar-one').tinyscrollbar();
      $('#scrollbar-two').tinyscrollbar();
      $('#scrollbar-three').tinyscrollbar();



      //Tabs
      $('#myTab a').click(function (e) {
        e.preventDefault();
        $(this).tab('show');
      })

      // SparkLine Graphs-Charts
      $(function () {
        try{
          $('#unique-visitors').sparkline('html', {
            type: 'bar',
            barColor: '#e26666',
            barWidth: 6,
            height: 30,
          });
          $('#monthly-sales').sparkline('html', {
            type: 'bar',
            barColor: '#b5799e',
            barWidth: 6,
            height: 30,
          });
          $('#current-balance').sparkline('html', {
            type: 'bar',
            barColor: '#579da9',
            barWidth: 6,
            height: 30,
          });
          $('#registrations').sparkline('html', {
            type: 'bar',
            barColor: '#dba26b',
            barWidth: 6,
            height: 30,
          });
        }catch(e){

        }
      });


      //Range Date Picker

      $('.report_range').daterangepicker({
        ranges: {
          'Today': ['today', 'today'],
          'Yesterday': ['yesterday', 'yesterday'],
          'Last 7 Days': [Date.today().add({
            days: -6
          }), 'today'],
          'Last 30 Days': [Date.today().add({
            days: -29
          }), 'today'],
          'This Month': [Date.today().moveToFirstDayOfMonth(), Date.today().moveToLastDayOfMonth()],
          'Last Month': [Date.today().moveToFirstDayOfMonth().add({
            months: -1
          }), Date.today().moveToFirstDayOfMonth().add({
            days: -1
          })]
        },
        opens: 'left',
        format: 'MM/dd/yyyy',
        separator: ' to ',
        startDate: Date.today().add({
          days: -29
        }),
        endDate: Date.today(),
        minDate: '01/01/2012',
        maxDate: '12/31/2013',
        locale: {
          applyLabel: 'Submit',
          fromLabel: 'From',
          toLabel: 'To',
          customRangeLabel: 'Custom Range',
          daysOfWeek: ['Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa'],
          monthNames: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'June', 'July', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
          firstDay: 1
        },
        showWeekNumbers: true,
        buttonClasses: ['btn-danger']
      },

      function (start, end) {
        $('.report_range span').html(start.toString('MMMM d, yyyy') + ' - ' + end.toString('MMMM d, yyyy'));
      });

      //Set the initial state of the picker label
      $('.report_range span').html(Date.today().add({
        days: -29
      }).toString('MMMM d, yyyy') + ' - ' + Date.today().toString('MMMM d, yyyy'));


      //Main menu navigation
      
      $('.submenu > a').click(function(e){
        e.preventDefault();
        var submenu = $(this).siblings('ul');
        var li = $(this).parents('li');
        var submenus = $('#mainnav li.submenu ul');
        var submenus_parents = $('#mainnav li.submenu');
        if(li.hasClass('open'))
        {
          if(($(window).width() > 768) || ($(window).width() < 479)) {
            submenu.slideUp();
          } else {
            submenu.fadeOut(250);
          }
          li.removeClass('open');
        } else 
        {
          if(($(window).width() > 768) || ($(window).width() < 479)) {
            submenus.slideUp();     
            submenu.slideDown();
          } else {
            submenus.fadeOut(250);      
            submenu.fadeIn(250);
          }
          submenus_parents.removeClass('open');   
          li.addClass('open');  
        }
      });
      
      var ul = $('#mainnav > ul');
      
      $('#mainnav > a').click(function(e)
      {
        e.preventDefault();
        var mainnav = $('#mainnav');
        if(mainnav.hasClass('open'))
        {
          mainnav.removeClass('open');
          ul.slideUp(250);
        } else 
        {
          mainnav.addClass('open');
          ul.slideDown(250);
        }
      });

      </script>
      
      
    </body>
    </html>