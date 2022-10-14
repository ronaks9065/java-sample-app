<template>
  <div id="menu">
    <div class="menu__top-container">
      <div class="menu__top">
        <img
            src="../assets/images/logos/vw-ag-logo-4x.png"
            alt="Volkswagen logo"
            class="menu__logo"
        />
        <router-link to="welcome">
          <img
              src="../assets/images/icons/vw-icon-close-grey-4x.png"
              alt="close"
              class="menu__icon"
          />
        </router-link>
      </div>
      <hr width="24%" class="hr__narrow"/>
      <img
          src="../assets/images/logos/kozern-logo-4x.png"
          alt="Volkswagen logo"
          class="menu__data-logo"
      />
      <hr width="24%" class="hr__narrow2"/>
    </div>

    <div class="reporting-page">
      <div class="reporting-links">
        <div>
          <a
              :href="this.csvAll"
              target="_blank"
              class="reporting-links-link"
              style="color: #335f7d"
          >Download all data as CSV file</a
          >
        </div>
        <div>
          <a
              :href="this.csvFeedback"
              target="_blank"
              class="reporting-links-link"
              style="color: #335f7d"
          >Download user feedback data as CSV file</a
          >
        </div>
      </div>
      <hr class="report-hr"/>
      <div class="reporting__top">
        <div class="report-filter">
          <div class="marginright">
            <p>Start Date</p>
            <select v-model="startDay" class="dd-report">
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
              <option value="8">8</option>
              <option value="9">9</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
              <option value="13">13</option>
              <option value="14">14</option>
              <option value="15">15</option>
              <option value="16">16</option>
              <option value="17">17</option>
              <option value="18">18</option>
              <option value="19">19</option>
              <option value="20">20</option>
              <option value="21">21</option>
              <option value="22">22</option>
              <option value="23">23</option>
              <option value="24">24</option>
              <option value="25">25</option>
              <option value="26">26</option>
              <option value="27">27</option>
              <option value="28">28</option>
              <option value="29">29</option>
              <option value="30">30</option>
              <option value="31">31</option>
            </select>
            .
            <select v-model="startMonth" class="dd-report">
              <option value="0">1</option>
              <option value="1">2</option>
              <option value="2">3</option>
              <option value="3">4</option>
              <option value="4">5</option>
              <option value="5">6</option>
              <option value="6">7</option>
              <option value="7">8</option>
              <option value="8">9</option>
              <option value="9">10</option>
              <option value="10">11</option>
              <option value="11">12</option>
            </select>
            .
            <select v-model="startYear" class="dd-report">
              <option value="2019">2019</option>
              <option value="2020">2020</option>
              <option value="2021">2021</option>
              <option value="2022">2022</option>
              <option value="2023">2023</option>
              <option value="2024">2024</option>
              <option value="2025">2025</option>
              <option value="2026">2026</option>
              <option value="2027">2027</option>
              <option value="2028">2028</option>
              <option value="2029">2029</option>
              <option value="2030">2030</option>
              <option value="2031">2031</option>
              <option value="2032">2032</option>
              <option value="2033">2033</option>
              <option value="2034">2034</option>
              <option value="2035">2035</option>
              <option value="2036">2036</option>
              <option value="2037">2037</option>
              <option value="2038">2038</option>
              <option value="2039">2039</option>
              <option value="2040">2040</option>
              <option value="2041">2041</option>
              <option value="2042">2042</option>
              <option value="2043">2043</option>
              <option value="2044">2044</option>
              <option value="2045">2045</option>
              <option value="2046">2046</option>
              <option value="2047">2047</option>
              <option value="2048">2048</option>
              <option value="2049">2049</option>
              <option value="2050">2050</option>
            </select>
          </div>
          <div class="marginright">
            <p>End Date</p>
            <select v-model="endDay" class="dd-report">
              <option value="1">1</option>
              <option value="2">2</option>
              <option value="3">3</option>
              <option value="4">4</option>
              <option value="5">5</option>
              <option value="6">6</option>
              <option value="7">7</option>
              <option value="8">8</option>
              <option value="9">9</option>
              <option value="10">10</option>
              <option value="11">11</option>
              <option value="12">12</option>
              <option value="13">13</option>
              <option value="14">14</option>
              <option value="15">15</option>
              <option value="16">16</option>
              <option value="17">17</option>
              <option value="18">18</option>
              <option value="19">19</option>
              <option value="20">20</option>
              <option value="21">21</option>
              <option value="22">22</option>
              <option value="23">23</option>
              <option value="24">24</option>
              <option value="25">25</option>
              <option value="26">26</option>
              <option value="27">27</option>
              <option value="28">28</option>
              <option value="29">29</option>
              <option value="30">30</option>
              <option value="31">31</option>
            </select>
            .
            <select v-model="endMonth" class="dd-report">
              <option value="0">1</option>
              <option value="1">2</option>
              <option value="2">3</option>
              <option value="3">4</option>
              <option value="4">5</option>
              <option value="5">6</option>
              <option value="6">7</option>
              <option value="7">8</option>
              <option value="8">9</option>
              <option value="9">10</option>
              <option value="10">11</option>
              <option value="11">12</option>
            </select>
            .
            <select v-model="endYear" class="dd-report">
              <option value="2019">2019</option>
              <option value="2020">2020</option>
              <option value="2021">2021</option>
              <option value="2022">2022</option>
              <option value="2023">2023</option>
              <option value="2024">2024</option>
              <option value="2025">2025</option>
              <option value="2026">2026</option>
              <option value="2027">2027</option>
              <option value="2028">2028</option>
              <option value="2029">2029</option>
              <option value="2030">2030</option>
              <option value="2031">2031</option>
              <option value="2032">2032</option>
              <option value="2033">2033</option>
              <option value="2034">2034</option>
              <option value="2035">2035</option>
              <option value="2036">2036</option>
              <option value="2037">2037</option>
              <option value="2038">2038</option>
              <option value="2039">2039</option>
              <option value="2040">2040</option>
              <option value="2041">2041</option>
              <option value="2042">2042</option>
              <option value="2043">2043</option>
              <option value="2044">2044</option>
              <option value="2045">2045</option>
              <option value="2046">2046</option>
              <option value="2047">2047</option>
              <option value="2048">2048</option>
              <option value="2049">2049</option>
              <option value="2050">2050</option>
            </select>
          </div>
          <button class="report-filter__button" @click="this.applyfilter">
            Apply
          </button>
        </div>
        <button
            class="report-filter__button"
            @click="reportRefresh()"
            style="postiion: relative, float: right"
        >
          Refresh
        </button>
      </div>

      <div class="reporting__table">
        <h3 class="colorbluedark reporting__header">Users</h3>
        <table>
          <tr>
            <th class="bold-sans border-row border-column">Unique Visitors</th>
            <th class="bold-sans border-row border-column">Sessions Total</th>
            <th class="bold-sans border-row border-column">
              Sessions Basiswissen
            </th>
            <th class="bold-sans border-row border-column">
              Sessions Anwenderwissen
            </th>
            <th class="bold-sans border-row">Sessions Führungskräftewissen</th>
          </tr>
          <tr>
            <td class="border-column">{{ this.data.user.uniqueVisitors }}</td>
            <td class="border-column">{{ this.data.user.sessionsTotal }}</td>
            <td class="border-column">{{ this.data.user.sessionsB }}</td>
            <td class="border-column">{{ this.data.user.sessionsA }}</td>
            <td>{{ this.data.user.sessionsF }}</td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
        </table>
      </div>

      <div class="reporting__table">
        <h3 class="colorbluedark reporting__header">Abschlüsse</h3>
        <table>
          <tr>
            <th class="bold-sans border-row border-column">Topic</th>
            <th class="bold-sans border-row border-column">Basiswissen</th>
            <th class="bold-sans border-row border-column">Anwenderwissen</th>
            <th class="bold-sans border-row">Führungskräftewissen</th>
          </tr>
          <tr>
            <td class="border-column">Total</td>
            <td class="border-column">
              {{ this.data.level.topicTotal.levelB }}
            </td>
            <td class="border-column">
              {{ this.data.level.topicTotal.levelA }}
            </td>
            <td>{{ this.data.level.topicTotal.levelF }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column">0</td>
            <td class="blue2 border-column">
              {{ this.data.level.topic0.levelB }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.level.topic0.levelA }}
            </td>
            <td class="blue2">{{ this.data.level.topic0.levelF }}</td>
          </tr>
          <tr>
            <td class="border-column">1</td>
            <td class="border-column">{{ this.data.level.topic1.levelB }}</td>
            <td class="border-column">{{ this.data.level.topic1.levelA }}</td>
            <td>{{ this.data.level.topic1.levelF }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column">2</td>
            <td class="blue2 border-column">
              {{ this.data.level.topic2.levelB }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.level.topic2.levelA }}
            </td>
            <td class="blue2">{{ this.data.level.topic2.levelF }}</td>
          </tr>
          <tr>
            <td class="border-column">3</td>
            <td class="border-column">{{ this.data.level.topic3.levelB }}</td>
            <td class="border-column">{{ this.data.level.topic3.levelA }}</td>
            <td>{{ this.data.level.topic3.levelF }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column">4</td>
            <td class="blue2 border-column">
              {{ this.data.level.topic4.levelB }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.level.topic4.levelA }}
            </td>
            <td class="blue2">{{ this.data.level.topic4.levelF }}</td>
          </tr>
          <tr>
            <td class="border-column">5</td>
            <td class="border-column">{{ this.data.level.topic5.levelB }}</td>
            <td class="border-column">{{ this.data.level.topic5.levelA }}</td>
            <td>{{ this.data.level.topic5.levelF }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column">6</td>
            <td class="blue2 border-column">
              {{ this.data.level.topic6.levelB }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.level.topic6.levelA }}
            </td>
            <td class="blue2">{{ this.data.level.topic6.levelF }}</td>
          </tr>
          <tr>
            <td class="border-column">7</td>
            <td class="border-column">{{ this.data.level.topic7.levelB }}</td>
            <td class="border-column">{{ this.data.level.topic7.levelA }}</td>
            <td>-</td>
          </tr>
          <tr>
            <td class="blue2 border-column">8</td>
            <td class="blue2 border-column">
              {{ this.data.level.topic8.levelB }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.level.topic8.levelA }}
            </td>
            <td class="blue2">-</td>
          </tr>
          <tr>
            <td class="border-column">9</td>
            <td class="border-column">{{ this.data.level.topic9.levelB }}</td>
            <td class="border-column">{{ this.data.level.topic9.levelA }}</td>
            <td>-</td>
          </tr>
          <tr>
            <td class="blue2 border-column">10</td>
            <td class="blue2 border-column">
              {{ this.data.level.topic10.levelB }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.level.topic10.levelA }}
            </td>
            <td class="blue2">-</td>
          </tr>
          <tr>
            <td class="border-column">11</td>
            <td class="border-column">{{ this.data.level.topic11.levelB }}</td>
            <td class="border-column">{{ this.data.level.topic11.levelA }}</td>
            <td>-</td>
          </tr>
          <tr>
            <td class="blue2 border-column">12</td>
            <td class="blue2 border-column">
              {{ this.data.level.topic12.levelB }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.level.topic12.levelA }}
            </td>
            <td class="blue2">-</td>
          </tr>
          <tr>
            <td class="blue2"></td>
            <td class="blue2"></td>
            <td class="blue2"></td>
            <td class="blue2"></td>
          </tr>
        </table>
      </div>

      <div class="reporting__table">
        <h3 class="colorbluedark reporting__header">Time Required</h3>
        <table>
          <tr>
            <th class="bold-sans border-row border-column">Level</th>
            <th class="bold-sans border-row border-column">Topic</th>
            <th class="bold-sans border-row border-column">Accessed</th>
            <th class="bold-sans border-row border-column">Passed</th>
            <th class="bold-sans border-row border-column">Min. Time</th>
            <th class="bold-sans border-row border-column">Max. Time</th>
            <th class="bold-sans border-row">Avg. Time</th>
          </tr>

          <tr>
            <td class="border-column">Basiswissen</td>
            <td class="border-column">0</td>
            <td class="border-column">
              {{ this.data.time.b.topic0.accessed }}
            </td>
            <td class="border-column">{{ this.data.time.b.topic0.passed }}</td>
            <td class="border-column">{{ this.data.time.b.topic0.minTime }}</td>
            <td class="border-column">{{ this.data.time.b.topic0.maxTime }}</td>
            <td>{{ this.data.time.b.topic0.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">1</td>
            <td class="blue2 order-column">
              {{ this.data.time.b.topic1.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic1.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic1.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic1.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.b.topic1.avgTime }}</td>
          </tr>
          <tr>
            <td class="border-column"></td>
            <td class="border-column">2</td>
            <td class="border-column">
              {{ this.data.time.b.topic2.accessed }}
            </td>
            <td class="border-column">{{ this.data.time.b.topic2.passed }}</td>
            <td class="border-column">{{ this.data.time.b.topic2.minTime }}</td>
            <td class="border-column">{{ this.data.time.b.topic2.maxTime }}</td>
            <td>{{ this.data.time.b.topic2.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">3</td>
            <td class="blue2 order-column">
              {{ this.data.time.b.topic3.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic3.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic3.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic3.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.b.topic3.avgTime }}</td>
          </tr>
          <tr>
            <td class="border-column"></td>
            <td class="border-column">4</td>
            <td class="border-column">
              {{ this.data.time.b.topic4.accessed }}
            </td>
            <td class="border-column">{{ this.data.time.b.topic4.passed }}</td>
            <td class="border-column">{{ this.data.time.b.topic4.minTime }}</td>
            <td class="border-column">{{ this.data.time.b.topic4.maxTime }}</td>
            <td>{{ this.data.time.b.topic4.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">5</td>
            <td class="blue2 order-column">
              {{ this.data.time.b.topic5.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic5.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic5.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic5.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.b.topic5.avgTime }}</td>
          </tr>
          <tr>
            <td class="border-column"></td>
            <td class="border-column">6</td>
            <td class="border-column">
              {{ this.data.time.b.topic6.accessed }}
            </td>
            <td class="border-column">{{ this.data.time.b.topic6.passed }}</td>
            <td class="border-column">{{ this.data.time.b.topic6.minTime }}</td>
            <td class="border-column">{{ this.data.time.b.topic6.maxTime }}</td>
            <td>{{ this.data.time.b.topic6.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">7</td>
            <td class="blue2 order-column">
              {{ this.data.time.b.topic7.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic7.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic7.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic7.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.b.topic7.avgTime }}</td>
          </tr>
          <tr>
            <td class="border-column"></td>
            <td class="border-column">8</td>
            <td class="border-column">
              {{ this.data.time.b.topic8.accessed }}
            </td>
            <td class="border-column">{{ this.data.time.b.topic8.passed }}</td>
            <td class="border-column">{{ this.data.time.b.topic8.minTime }}</td>
            <td class="border-column">{{ this.data.time.b.topic8.maxTime }}</td>
            <td>{{ this.data.time.b.topic8.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">9</td>
            <td class="blue2 order-column">
              {{ this.data.time.b.topic9.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic9.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic9.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic9.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.b.topic9.avgTime }}</td>
          </tr>
          <tr>
            <td class="border-column"></td>
            <td class="border-column">10</td>
            <td class="border-column">
              {{ this.data.time.b.topic10.accessed }}
            </td>
            <td class="border-column">{{ this.data.time.b.topic10.passed }}</td>
            <td class="border-column">
              {{ this.data.time.b.topic10.minTime }}
            </td>
            <td class="border-column">
              {{ this.data.time.b.topic10.maxTime }}
            </td>
            <td>{{ this.data.time.b.topic10.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">11</td>
            <td class="blue2 order-column">
              {{ this.data.time.b.topic11.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic11.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic11.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.b.topic11.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.b.topic11.avgTime }}</td>
          </tr>
          <tr>
            <td class="border-column border-row"></td>
            <td class="border-column border-row">12</td>
            <td class="border-column">
              {{ this.data.time.b.topic12.accessed }}
            </td>
            <td class="border-column">{{ this.data.time.b.topic12.passed }}</td>
            <td class="border-column">
              {{ this.data.time.b.topic12.minTime }}
            </td>
            <td class="border-column">
              {{ this.data.time.b.topic12.maxTime }}
            </td>
            <td>{{ this.data.time.b.topic12.avgTime }}</td>
          </tr>

          <!-- ANWENDERWISSEN TIMES -->
          <tr>
            <td class="blue2 border-column">Anwenderwissen</td>
            <td class="blue2 border-column">0</td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic0.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic0.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic0.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic0.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.a.topic0.avgTime }}</td>
          </tr>
          <tr>
            <td class=" border-column"></td>
            <td class=" border-column">1</td>
            <td class=" order-column">
              {{ this.data.time.a.topic1.accessed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic1.passed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic1.minTime }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic1.maxTime }}
            </td>
            <td class="">{{ this.data.time.a.topic1.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">2</td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic2.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic2.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic2.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic2.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.a.topic2.avgTime }}</td>
          </tr>
          <tr>
            <td class=" border-column"></td>
            <td class=" border-column">3</td>
            <td class=" order-column">
              {{ this.data.time.a.topic3.accessed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic3.passed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic3.minTime }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic3.maxTime }}
            </td>
            <td class="">{{ this.data.time.a.topic3.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">4</td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic4.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic4.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic4.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic4.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.a.topic4.avgTime }}</td>
          </tr>
          <tr>
            <td class=" border-column"></td>
            <td class=" border-column">5</td>
            <td class=" order-column">
              {{ this.data.time.a.topic5.accessed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic5.passed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic5.minTime }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic5.maxTime }}
            </td>
            <td class="">{{ this.data.time.a.topic5.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">6</td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic6.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic6.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic6.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic6.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.a.topic6.avgTime }}</td>
          </tr>
          <tr>
            <td class=" border-column"></td>
            <td class=" border-column">7</td>
            <td class=" order-column">
              {{ this.data.time.a.topic7.accessed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic7.passed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic7.minTime }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic7.maxTime }}
            </td>
            <td class="">{{ this.data.time.a.topic7.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">8</td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic8.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic8.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic8.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic8.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.a.topic8.avgTime }}</td>
          </tr>
          <tr>
            <td class=" border-column"></td>
            <td class=" border-column">9</td>
            <td class=" order-column">
              {{ this.data.time.a.topic9.accessed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic9.passed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic9.minTime }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic9.maxTime }}
            </td>
            <td class="">{{ this.data.time.a.topic9.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">10</td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic10.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic10.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic10.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic10.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.a.topic10.avgTime }}</td>
          </tr>
          <tr>
            <td class=" border-column"></td>
            <td class=" border-column">11</td>
            <td class=" order-column">
              {{ this.data.time.a.topic11.accessed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic11.passed }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic11.minTime }}
            </td>
            <td class=" border-column">
              {{ this.data.time.a.topic11.maxTime }}
            </td>
            <td class="">{{ this.data.time.a.topic11.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column border-row"></td>
            <td class="blue2 border-column border-row">12</td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic12.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic12.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic12.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.a.topic12.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.a.topic12.avgTime }}</td>
          </tr>
          <tr>
            <td class="border-column">Führungskräftewissen</td>
            <td class="border-column">0</td>
            <td class="border-column">
              {{ this.data.time.f.topic0.accessed }}
            </td>
            <td class="border-column">{{ this.data.time.f.topic0.passed }}</td>
            <td class="border-column">{{ this.data.time.f.topic0.minTime }}</td>
            <td class="border-column">{{ this.data.time.f.topic0.maxTime }}</td>
            <td>{{ this.data.time.f.topic0.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">1</td>
            <td class="blue2 order-column">
              {{ this.data.time.f.topic1.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.f.topic1.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.f.topic1.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.f.topic1.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.f.topic1.avgTime }}</td>
          </tr>
          <tr>
            <td class="border-column"></td>
            <td class="border-column">2</td>
            <td class="border-column">
              {{ this.data.time.f.topic2.accessed }}
            </td>
            <td class="border-column">{{ this.data.time.f.topic2.passed }}</td>
            <td class="border-column">{{ this.data.time.f.topic2.minTime }}</td>
            <td class="border-column">{{ this.data.time.f.topic2.maxTime }}</td>
            <td>{{ this.data.time.f.topic2.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">3</td>
            <td class="blue2 order-column">
              {{ this.data.time.f.topic3.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.f.topic3.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.f.topic3.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.f.topic3.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.f.topic3.avgTime }}</td>
          </tr>
          <tr>
            <td class="border-column"></td>
            <td class="border-column">4</td>
            <td class="border-column">
              {{ this.data.time.f.topic4.accessed }}
            </td>
            <td class="border-column">{{ this.data.time.f.topic4.passed }}</td>
            <td class="border-column">{{ this.data.time.f.topic4.minTime }}</td>
            <td class="border-column">{{ this.data.time.f.topic4.maxTime }}</td>
            <td>{{ this.data.time.f.topic4.avgTime }}</td>
          </tr>
          <tr>
            <td class="blue2 border-column"></td>
            <td class="blue2 border-column">5</td>
            <td class="blue2 order-column">
              {{ this.data.time.f.topic5.accessed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.f.topic5.passed }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.f.topic5.minTime }}
            </td>
            <td class="blue2 border-column">
              {{ this.data.time.f.topic5.maxTime }}
            </td>
            <td class="blue2">{{ this.data.time.f.topic5.avgTime }}</td>
          </tr>
          <tr>
            <td class="border-column"></td>
            <td class="border-column">6</td>
            <td class="border-column">
              {{ this.data.time.f.topic6.accessed }}
            </td>
            <td class="border-column">{{ this.data.time.f.topic6.passed }}</td>
            <td class="border-column">{{ this.data.time.f.topic6.minTime }}</td>
            <td class="border-column">{{ this.data.time.f.topic6.maxTime }}</td>
            <td>{{ this.data.time.f.topic6.avgTime }}</td>
          </tr>
          <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
          </tr>
        </table>

        <div class="reporting__table">
          <h3 class="colorbluedark reporting__header">Devices</h3>
          <table>
            <tr>
              <th class="bold-sans border-row border-column">Desktop</th>
              <th class="bold-sans border-row border-column">Tablet</th>
              <th class="bold-sans border-row border-column">
                Mobile
              </th>
            </tr>

            <tr>
              <td class="border-column">#</td>
              <td class="border-column">#</td>
              <td class="border-column">#</td>
            </tr>
            <tr>
              <td></td>
              <td></td>
              <td></td>
            </tr>
          </table>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {mapActions} from "vuex";
import {getReport} from "../services/access.service";
import {csvAll, csvFeedback} from "../services/reporting.service";
import {EventBus} from "../event-bus";

function generateReportTopicMockData() {
  let res = [];
  for (let i = 0; i < 13; i++)
    res.push({
      levelB: 3,
      levelA: 3,
      levelF: i < 7 ? 3 : "-"
    });
  return res;
}

export default {
  name: "reporting2",
  data: () => ({
    renderPage: false,
    startDay: 1,
    startMonth: 0,
    startYear: 2019,
    endDay: 1,
    endMonth: 0,
    endYear: 2019,
    csvAll: csvAll,
    csvFeedback: csvFeedback,
    data: {
      user: {
        uniqueVisitors: 3,
        sessionsTotal: 3,
        sessionsB: 3,
        sessionsA: 3,
        sessionsF: 3
      },
      level: {
        topicTotal: {
          levelB: 3,
          levelA: 3,
          levelF: 3
        },
        topic: tmp(),
        topic1: {
          levelB: 3,
          levelA: 3,
          levelF: 3
        },
        topic2: {
          levelB: 3,
          levelA: 3,
          levelF: 3
        },
        topic3: {
          levelB: 3,
          levelA: 3,
          levelF: 3
        },
        topic4: {
          levelB: 3,
          levelA: 3,
          levelF: 3
        },
        topic5: {
          levelB: 3,
          levelA: 3,
          levelF: 3
        },
        topic6: {
          levelB: 3,
          levelA: 3,
          levelF: 3
        },
        topic7: {
          levelB: 3,
          levelA: 3,
          levelF: "-"
        },
        topic8: {
          levelB: 3,
          levelA: 3,
          levelF: "-"
        },
        topic9: {
          levelB: 3,
          levelA: 3,
          levelF: "-"
        },
        topic10: {
          levelB: 3,
          levelA: 3,
          levelF: "-"
        },
        topic11: {
          levelB: 3,
          levelA: 3,
          levelF: "-"
        },
        topic12: {
          levelB: 3,
          levelA: 3,
          levelF: "-"
        }
      },
      time: {
        b: {
          topic0: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic1: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic2: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic3: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic4: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic5: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic6: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic7: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic8: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic9: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic10: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic11: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic12: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          }
        },
        a: {
          topic0: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic1: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic2: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic3: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic4: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic5: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic6: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic7: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic8: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic9: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic10: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic11: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic12: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          }
        },
        f: {
          topic0: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic1: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic2: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic3: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic4: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic5: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          },
          topic6: {
            accessed: 3,
            passed: 3,
            minTime: 3,
            maxTime: 3,
            avgTime: 3
          }
        }
      },
      device: {
        desktop: 3,
        tablet: 3,
        mobile: 3
      }
    }
  }),
  methods: {
    ...mapActions(["commitSelectQuiz", "commitTransitionAnimation"]),
    reportRefresh: function () {
      this.resetFilter();
      this.fetchReport();
    },
    resetFilter: function () {
      let filterDDs = document.getElementsByClassName("dd-report");
      for (var i = 0; i < filterDDs.length; i++) {
        filterDDs[i].selectedIndex = 0;
      }
    },
    formatDate: function (year, month, day) {
      const date = new Date(parseInt(year), parseInt(month), parseInt(day));

      return date.getTime();
    },
    applyfilter: function () {
      getReport(
          this.formatDate(this.startYear, this.startMonth, this.startDay),
          this.formatDate(this.endYear, this.endMonth, this.endDay)
      ).then(res => this.populate(res.data));
    },
    fetchReport: function () {
      getReport().then(res => this.populate(res.data));
    },
    populate: function (res) {
      // USER DATA
      this.data.user.uniqueVisitors = res.userReportingDTO.uniqueVisitors;
      this.data.user.sessionsTotal = res.userReportingDTO.sessions;
      this.data.user.sessionsB = res.userReportingDTO.baseSessions;
      this.data.user.sessionsA = res.userReportingDTO.advancedSessions;
      this.data.user.sessionsF = res.userReportingDTO.expertSessions;

      // LEVEL DATA
      // TOPIC TOTAL
      this.data.level.topicTotal.levelB =
          res.quizFinishingsReportDTO.baseResultsSum;
      this.data.level.topicTotal.levelA =
          res.quizFinishingsReportDTO.advancedResultsSum;
      this.data.level.topicTotal.levelF =
          res.quizFinishingsReportDTO.expertResultsSum;

      // TOPIC 0
      for (let i = 0; i < 13; i++) {
        this.data.level.topic[i].levelB =
            res.quizFinishingsReportDTO.baseResults[0];
        this.data.level.topic[i].levelA =
            res.quizFinishingsReportDTO.advancedResults[0];
        if (i < 7) {
          this.data.level.topic[i].levelF =
              res.quizFinishingsReportDTO.expertResults[0];
        }
      }

      // TOPIC 1
      this.data.level.topic1.levelB =
          res.quizFinishingsReportDTO.baseResults[1];
      this.data.level.topic1.levelA =
          res.quizFinishingsReportDTO.advancedResults[1];
      this.data.level.topic1.levelF =
          res.quizFinishingsReportDTO.expertResults[1];

      // TOPIC 2
      this.data.level.topic2.levelB =
          res.quizFinishingsReportDTO.baseResults[2];
      this.data.level.topic2.levelA =
          res.quizFinishingsReportDTO.advancedResults[2];
      this.data.level.topic2.levelF =
          res.quizFinishingsReportDTO.expertResults[2];

      // TOPIC 3
      this.data.level.topic3.levelB =
          res.quizFinishingsReportDTO.baseResults[3];
      this.data.level.topic3.levelA =
          res.quizFinishingsReportDTO.advancedResults[3];
      this.data.level.topic3.levelF =
          res.quizFinishingsReportDTO.expertResults[3];

      // TOPIC 4
      this.data.level.topic4.levelB =
          res.quizFinishingsReportDTO.baseResults[4];
      this.data.level.topic4.levelA =
          res.quizFinishingsReportDTO.advancedResults[4];
      this.data.level.topic4.levelF =
          res.quizFinishingsReportDTO.expertResults[4];

      // TOPIC 5
      this.data.level.topic5.levelB =
          res.quizFinishingsReportDTO.baseResults[5];
      this.data.level.topic5.levelA =
          res.quizFinishingsReportDTO.advancedResults[5];
      this.data.level.topic5.levelF =
          res.quizFinishingsReportDTO.expertResults[5];

      // TOPIC 6
      this.data.level.topic6.levelB =
          res.quizFinishingsReportDTO.baseResults[6];
      this.data.level.topic6.levelA =
          res.quizFinishingsReportDTO.advancedResults[6];
      this.data.level.topic6.levelF =
          res.quizFinishingsReportDTO.expertResults[6];

      // TOPIC 7
      this.data.level.topic7.levelB =
          res.quizFinishingsReportDTO.baseResults[7];
      this.data.level.topic7.levelA =
          res.quizFinishingsReportDTO.advancedResults[7];

      // TOPIC 8
      this.data.level.topic8.levelB =
          res.quizFinishingsReportDTO.baseResults[8];
      this.data.level.topic8.levelA =
          res.quizFinishingsReportDTO.advancedResults[8];

      // TOPIC 9
      this.data.level.topic9.levelB =
          res.quizFinishingsReportDTO.baseResults[9];
      this.data.level.topic9.levelA =
          res.quizFinishingsReportDTO.advancedResults[9];

      // TOPIC 10
      this.data.level.topic10.levelB =
          res.quizFinishingsReportDTO.baseResults[10];
      this.data.level.topic10.levelA =
          res.quizFinishingsReportDTO.advancedResults[10];

      // TOPIC 11
      this.data.level.topic11.levelB =
          res.quizFinishingsReportDTO.baseResults[11];
      this.data.level.topic11.levelA =
          res.quizFinishingsReportDTO.advancedResults[11];

      // TOPIC 12
      this.data.level.topic12.levelB =
          res.quizFinishingsReportDTO.baseResults[12];
      this.data.level.topic12.levelA =
          res.quizFinishingsReportDTO.advancedResults[12];

      // TIME DATA
      // BASISWISSEN
      // TOPIC 0
      this.data.time.b.topic0.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[0].accessedAmount;
      this.data.time.b.topic0.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[0].finishedAmount;
      this.data.time.b.topic0.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[0].minimumTime;
      this.data.time.b.topic0.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[0].maximumTime;
      this.data.time.b.topic0.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[0].averageTime;

      // TOPIC 1
      this.data.time.b.topic1.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[1].accessedAmount;
      this.data.time.b.topic1.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[1].finishedAmount;
      this.data.time.b.topic1.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[1].minimumTime;
      this.data.time.b.topic1.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[1].maximumTime;
      this.data.time.b.topic1.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[1].averageTime;

      // TOPIC 2
      this.data.time.b.topic2.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[2].accessedAmount;
      this.data.time.b.topic2.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[2].finishedAmount;
      this.data.time.b.topic2.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[2].minimumTime;
      this.data.time.b.topic2.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[2].maximumTime;
      this.data.time.b.topic2.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[2].averageTime;

      // TOPIC 3
      this.data.time.b.topic3.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[3].accessedAmount;
      this.data.time.b.topic3.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[3].finishedAmount;
      this.data.time.b.topic3.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[3].minimumTime;
      this.data.time.b.topic3.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[3].maximumTime;
      this.data.time.b.topic3.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[3].averageTime;

      // TOPIC 4
      this.data.time.b.topic4.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[4].accessedAmount;
      this.data.time.b.topic4.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[4].finishedAmount;
      this.data.time.b.topic4.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[4].minimumTime;
      this.data.time.b.topic4.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[4].maximumTime;
      this.data.time.b.topic4.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[4].averageTime;

      // TOPIC 5
      this.data.time.b.topic5.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[5].accessedAmount;
      this.data.time.b.topic5.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[5].finishedAmount;
      this.data.time.b.topic5.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[5].minimumTime;
      this.data.time.b.topic5.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[5].maximumTime;
      this.data.time.b.topic5.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[5].averageTime;

      // TOPIC 6
      this.data.time.b.topic6.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[6].accessedAmount;
      this.data.time.b.topic6.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[6].finishedAmount;
      this.data.time.b.topic6.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[6].minimumTime;
      this.data.time.b.topic6.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[6].maximumTime;
      this.data.time.b.topic6.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[6].averageTime;

      // TOPIC 7
      this.data.time.b.topic7.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[7].accessedAmount;
      this.data.time.b.topic7.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[7].finishedAmount;
      this.data.time.b.topic7.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[7].minimumTime;
      this.data.time.b.topic7.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[7].maximumTime;
      this.data.time.b.topic7.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[7].averageTime;

      // TOPIC 8
      this.data.time.b.topic8.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[8].accessedAmount;
      this.data.time.b.topic8.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[8].finishedAmount;
      this.data.time.b.topic8.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[8].minimumTime;
      this.data.time.b.topic8.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[8].maximumTime;
      this.data.time.b.topic8.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[8].averageTime;

      // TOPIC 9
      this.data.time.b.topic9.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[9].accessedAmount;
      this.data.time.b.topic9.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[9].finishedAmount;
      this.data.time.b.topic9.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[9].minimumTime;
      this.data.time.b.topic9.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[9].maximumTime;
      this.data.time.b.topic9.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[9].averageTime;

      // TOPIC 10
      this.data.time.b.topic10.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[10].accessedAmount;
      this.data.time.b.topic10.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[10].finishedAmount;
      this.data.time.b.topic10.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[10].minimumTime;
      this.data.time.b.topic10.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[10].maximumTime;
      this.data.time.b.topic10.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[10].averageTime;

      // TOPIC 11
      this.data.time.b.topic11.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[11].accessedAmount;
      this.data.time.b.topic11.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[11].finishedAmount;
      this.data.time.b.topic11.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[11].minimumTime;
      this.data.time.b.topic11.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[11].maximumTime;
      this.data.time.b.topic11.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[11].averageTime;

      // TOPIC 12
      this.data.time.b.topic12.accessed =
          res.timeRequiredReportingDTO.timesRequiredForBase[12].accessedAmount;
      this.data.time.b.topic12.passed =
          res.timeRequiredReportingDTO.timesRequiredForBase[12].finishedAmount;
      this.data.time.b.topic12.minTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[12].minimumTime;
      this.data.time.b.topic12.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[12].maximumTime;
      this.data.time.b.topic12.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForBase[12].averageTime;

      // ANWENDERWISSEN
      // TOPIC 0
      this.data.time.a.topic0.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[0].accessedAmount;
      this.data.time.a.topic0.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[0].finishedAmount;
      this.data.time.a.topic0.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[0].minimumTime;
      this.data.time.a.topic0.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[0].maximumTime;
      this.data.time.a.topic0.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[0].averageTime;

      // TOPIC 1
      this.data.time.a.topic1.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[1].accessedAmount;
      this.data.time.a.topic1.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[1].finishedAmount;
      this.data.time.a.topic1.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[1].minimumTime;
      this.data.time.a.topic1.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[1].maximumTime;
      this.data.time.a.topic1.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[1].averageTime;

      // TOPIC 2
      this.data.time.a.topic2.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[2].accessedAmount;
      this.data.time.a.topic2.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[2].finishedAmount;
      this.data.time.a.topic2.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[2].minimumTime;
      this.data.time.a.topic2.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[2].maximumTime;
      this.data.time.a.topic2.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[2].averageTime;

      // TOPIC 3
      this.data.time.a.topic3.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[3].accessedAmount;
      this.data.time.a.topic3.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[3].finishedAmount;
      this.data.time.a.topic3.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[3].minimumTime;
      this.data.time.a.topic3.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[3].maximumTime;
      this.data.time.a.topic3.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[3].averageTime;

      // TOPIC 4
      this.data.time.a.topic4.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[4].accessedAmount;
      this.data.time.a.topic4.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[4].finishedAmount;
      this.data.time.a.topic4.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[4].minimumTime;
      this.data.time.a.topic4.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[4].maximumTime;
      this.data.time.a.topic4.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[4].averageTime;

      // TOPIC 5
      this.data.time.a.topic5.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[5].accessedAmount;
      this.data.time.a.topic5.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[5].finishedAmount;
      this.data.time.a.topic5.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[5].minimumTime;
      this.data.time.a.topic5.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[5].maximumTime;
      this.data.time.a.topic5.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[5].averageTime;

      // TOPIC 6
      this.data.time.a.topic6.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[6].accessedAmount;
      this.data.time.a.topic6.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[6].finishedAmount;
      this.data.time.a.topic6.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[6].minimumTime;
      this.data.time.a.topic6.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[6].maximumTime;
      this.data.time.a.topic6.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[6].averageTime;

      // TOPIC 7
      this.data.time.a.topic7.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[7].accessedAmount;
      this.data.time.a.topic7.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[7].finishedAmount;
      this.data.time.a.topic7.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[7].minimumTime;
      this.data.time.a.topic7.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[7].maximumTime;
      this.data.time.a.topic7.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[7].averageTime;

      // TOPIC 8
      this.data.time.a.topic8.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[8].accessedAmount;
      this.data.time.a.topic8.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[8].finishedAmount;
      this.data.time.a.topic8.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[8].minimumTime;
      this.data.time.a.topic8.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[8].maximumTime;
      this.data.time.a.topic8.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[8].averageTime;

      // TOPIC 9
      this.data.time.a.topic9.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[9].accessedAmount;
      this.data.time.a.topic9.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[9].finishedAmount;
      this.data.time.a.topic9.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[9].minimumTime;
      this.data.time.a.topic9.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[9].maximumTime;
      this.data.time.a.topic9.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[9].averageTime;

      // TOPIC 10
      this.data.time.a.topic10.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[10].accessedAmount;
      this.data.time.a.topic10.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[10].finishedAmount;
      this.data.time.a.topic10.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[10].minimumTime;
      this.data.time.a.topic10.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[10].maximumTime;
      this.data.time.a.topic10.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[10].averageTime;

      // TOPIC 11
      this.data.time.a.topic11.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[11].accessedAmount;
      this.data.time.a.topic11.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[11].finishedAmount;
      this.data.time.a.topic11.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[11].minimumTime;
      this.data.time.a.topic11.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[11].maximumTime;
      this.data.time.a.topic11.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[11].averageTime;

      // TOPIC 12
      this.data.time.a.topic12.accessed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[12].accessedAmount;
      this.data.time.a.topic12.passed =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[12].finishedAmount;
      this.data.time.a.topic12.minTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[12].minimumTime;
      this.data.time.a.topic12.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[12].maximumTime;
      this.data.time.a.topic12.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForAdvanced[12].averageTime;

      // FÜHRUNGSKRÄFTEWISSEN
      // TOPIC 0
      this.data.time.f.topic0.accessed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[0].accessedAmount;
      this.data.time.f.topic0.passed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[0].finishedAmount;
      this.data.time.f.topic0.minTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[0].minimumTime;
      this.data.time.f.topic0.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[0].maximumTime;
      this.data.time.f.topic0.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[0].averageTime;

      // TOPIC 1
      this.data.time.f.topic1.accessed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[1].accessedAmount;
      this.data.time.f.topic1.passed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[1].finishedAmount;
      this.data.time.f.topic1.minTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[1].minimumTime;
      this.data.time.f.topic1.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[1].maximumTime;
      this.data.time.f.topic1.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[1].averageTime;

      // TOPIC 2
      this.data.time.f.topic2.accessed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[2].accessedAmount;
      this.data.time.f.topic2.passed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[2].finishedAmount;
      this.data.time.f.topic2.minTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[2].minimumTime;
      this.data.time.f.topic2.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[2].maximumTime;
      this.data.time.f.topic2.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[2].averageTime;

      // TOPIC 3
      this.data.time.f.topic3.accessed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[3].accessedAmount;
      this.data.time.f.topic3.passed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[3].finishedAmount;
      this.data.time.f.topic3.minTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[3].minimumTime;
      this.data.time.f.topic3.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[3].maximumTime;
      this.data.time.f.topic3.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[3].averageTime;

      // TOPIC 4
      this.data.time.f.topic4.accessed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[4].accessedAmount;
      this.data.time.f.topic4.passed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[4].finishedAmount;
      this.data.time.f.topic4.minTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[4].minimumTime;
      this.data.time.f.topic4.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[4].maximumTime;
      this.data.time.f.topic4.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[4].averageTime;

      // TOPIC 5
      this.data.time.f.topic5.accessed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[5].accessedAmount;
      this.data.time.f.topic5.passed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[5].finishedAmount;
      this.data.time.f.topic5.minTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[5].minimumTime;
      this.data.time.f.topic5.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[5].maximumTime;
      this.data.time.f.topic5.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[5].averageTime;

      // TOPIC 6
      this.data.time.f.topic6.accessed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[6].accessedAmount;
      this.data.time.f.topic6.passed =
          res.timeRequiredReportingDTO.timesRequiredForExpert[6].finishedAmount;
      this.data.time.f.topic6.minTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[6].minimumTime;
      this.data.time.f.topic6.maxTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[6].maximumTime;
      this.data.time.f.topic6.avgTime =
          res.timeRequiredReportingDTO.timesRequiredForExpert[6].averageTime;

      // DEVICE DATA
      this.data.device.desktop = res.sourceReportDTO.desktop;
      this.data.device.tablet = res.sourceReportDTO.tablet;
      this.data.device.mobile = res.sourceReportDTO.mobile;
    }
  },
  mounted() {
    console.log(this.data.level.topic);
    console.log(this.data.level.topic[0].levelA);
    getReport();

    EventBus.$on(
        "report-loaded",
        function () {
          this.populate();
        }.bind(this)
    );
  }
};
</script>