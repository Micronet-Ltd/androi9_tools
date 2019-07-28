/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.loganalysis.parser;

import com.android.loganalysis.item.DumpsysItem;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.List;

/**
 * Unit tests for {@link DumpsysParser}
 */
public class DumpsysParserTest extends TestCase {

    /**
     * Test that normal input is parsed.
     */
    public void testDumpsysParser() {
        List<String> inputBlock =
                Arrays.asList(
                        "DUMP OF SERVICE batterystats:",
                        "Battery History (37% used, 95KB used of 256KB, 166 strings using 15KB):",
                        "     0 (9) RESET:TIME: 2014-12-09-11-33-29",
                        "     +1s067ms (1) 100 c0500020 -wifi_full_lock -wifi_scan",
                        "     +3s297ms (2) 100 80400020 -wake_lock -screen",
                        "     +30m02s075ms (1) 100 c0500020 wifi_signal_strength=4 wifi_suppl=completed",
                        "     +30m03s012ms (2) 099 c0500020 temp=306 volt=4217",
                        "     +33m48s967ms (1) 099 f8400020 +wifi_scan",
                        "     +33m49s335ms (2) 098 f0400020 temp=324 -wifi_scan",
                        "Statistics since last charge:",
                        " Time on battery: 2h 21m 5s 622ms (12.0%) realtime, 7m 54s 146ms (0.7%) uptime",
                        " Time on battery screen off: 2h 5m 55s 3ms (1%) realtime, 7m 4s 5ms (7%) uptime",
                        " Total run time: 19h 38m 43s 650ms realtime, 17h 25m 32s 175ms uptime",
                        " All kernel wake locks:",
                        " Kernel Wake lock PowerManagerService.WakeLocks: 1h 3m 50s 5ms (8 times) realtime",
                        " Kernel Wake lock event0-2656 : 3m 49s 268ms (2399 times) realtime",
                        " Kernel Wake lock wlan_wd_wake: 3m 34s 639ms (1751 times) realtime",
                        " Kernel Wake lock wlan_rx_wake: 3m 19s 887ms (225 times) realtime",
                        " Kernel Wake lock wlan_tx_wake: 2m 19s 887ms (225 times) realtime",
                        " Kernel Wake lock tx_wake: 1m 19s 887ms (225 times) realtime",
                        " ",
                        " All partial wake locks:",
                        " Wake lock u0a7 NlpWakeLock: 8m 13s 203ms (1479 times) realtime",
                        " Wake lock u0a7 NlpCollectorWakeLock: 6m 29s 18ms (238 times) realtime",
                        " Wake lock u0a7 GCM_CONN_ALARM: 6m 8s 587ms (239 times) realtime",
                        " Wake lock 1000 *alarm*: 5m 11s 316ms (1469 times) realtime",
                        " Wake lock u10 xxx: 4m 11s 316ms (1469 times) realtime",
                        " Wake lock u30 cst: 2m 11s 316ms (1469 times) realtime",
                        " ",
                        " All wakeup reasons:",
                        " Wakeup reason 200:qcom,smd-rpm:222:fc4: 11m 49s 332ms (0 times) realtime",
                        " Wakeup reason 200:qcom,smd-rpm: 48s 45ms (0 times) realtime",
                        " Wakeup reason 2:qcom,smd-rpm:2:f0.qm,mm:22:fc4mi: 3s 417ms (0 times) realtime",
                        " Wakeup reason 188:qcom,smd-adsp:200:qcom,smd-rpm: 1s 656ms (0 times) realtime",
                        " Wakeup reason 58:qcom,smsm-modem:2:qcom,smd-rpm: 6m 16s 1ms (5 times) realtime",
                        " Wakeup reason 57:qcom,smd-modem:200:qcom,smd-rpm: 40s 995ms (0 times) realtime",
                        " Wakeup reason unknown: 8s 455ms (0 times) realtime",
                        " Wakeup reason 9:bcmsdh_sdmmc:2:qcomd-rpm:240:mso: 8m 5s 9ms (0 times) realtime",
                        " ",
                        " 0:",
                        "    User activity: 2 other",
                        "    Wake lock SCREEN_FROZEN realtime",
                        "    Sensor 0: 9s 908ms realtime (1 times)",
                        "    Sensor 1: 9s 997ms realtime (1 times)",
                        "    Foreground for: 2h 21m 5s 622ms",
                        "    Apk android:",
                        "      24 wakeup alarms",
                        " u0a9:",
                        "    Mobile network: 8.1KB received, 1.6KB sent (packets 291 received, 342 sent)",
                        "    Mobile radio active: 3m 43s 890ms (34.2%) 39x @ 354 mspp",
                        "    Sensor 2: 12m 13s 15ms realtime (5 times)",
                        "    Sensor 32: (not used)",
                        "    Sensor 35: (not used)",
                        "DUMP OF SERVICE package:",
                        "Package [com.google.android.calculator] (e075c9d):",
                        "  userId=10071",
                        "  secondaryCpuAbi=null",
                        "  versionCode=73000302 minSdk=10000 targetSdk=10000",
                        "  versionName=7.3 (3821978)",
                        "  splits=[base]",
                        "Package [com.google.android.googlequicksearchbox] (607929e):",
                        "  userId=10037",
                        "  pkg=Package{af43294 com.google.android.googlequicksearchbox}",
                        "  versionCode=300734793 minSdk=10000 targetSdk=10000",
                        "  versionName=6.16.35.26.arm64",
                        "  apkSigningVersion=2",
                        "DUMP OF SERVICE procstats:",
                        "COMMITTED STATS FROM 2015-03-20-02-01-02 (checked in):",
                        "  * com.android.systemui / u0a22 / v22:",
                        "           TOTAL: 100% (159MB-160MB-161MB/153MB-153MB-154MB over 13)",
                        "      Persistent: 100% (159MB-160MB-161MB/153MB-153MB-154MB over 13)",
                        "  * com.google.process.gapps / u0a9 / v22:",
                        "           TOTAL: 100% (22MB-24MB-25MB/18MB-19MB-20MB over 13)",
                        "          Imp Fg: 100% (22MB-24MB-25MB/18MB-19MB-20MB over 13)",
                        "DUMP OF SERVICE wifi:",
                        "Wi-Fi is enabled",
                        "rec[0]: time=10-09 00:25:16.737 processed=DefaultState org=DeviceActiveState "
                                + "dest=<null> what=155654(0x26006)",
                        "mScreenOff true",
                        " rec[0]: time=10-08 16:49:55.034 processed=WatchdogEnabledState org=OnlineState "
                                + "dest=OnlineWatchState what=135170(0x21002)",
                        "rec[30]: time=10-08 13:06:50.379 processed=DriverStartedState org=ConnectedState "
                                + "dest=<null> what=131143(0x20047) (1)CMD_START_SCAN  rt=4720806/7884852 10013 51 "
                                + "ic=0 proc(ms):14 onGoing full started:1444334810368,11 cnt=24 rssi=-127 f=-1 "
                                + "sc=0 link=-1 tx=1.5, 1.7, 0.0  rx=8.4 fiv=20000 [on:3266 tx:65 rx:556 "
                                + "period:1268] from screen [on:266962 period:266959]",
                        "rec[357]: time=10-08 13:10:13.199 processed=DriverStartedState org=ConnectedState "
                                + "dest=<null> what=131143(0x20047) (-2)CMD_START_SCAN  rt=4923625/8087671 10013 "
                                + "175 ic=0 proc(ms):2 onGoing full started:1444335011199,1999 cnt=24 rssi=-127 "
                                + "f=-1 sc=0 link=-1 tx=8.4, 1.7, 0.0  rx=6.7 fiv=20000 [on:0 tx:0 rx:0 period:990]"
                                + "from screen [on:467747 period:469779]",
                        "WifiConfigStore - Log Begin ----",
                        "10-08 11:09:14.653 - Event [IFNAME=wlan0 CTRL-EVENT-SCAN-STARTED ]",
                        "10-08 13:06:29.489 - Event [IFNAME=wlan0 CTRL-EVENT-DISCONNECTED "
                                + "bssid=9c:1c:12:c3:d0:72 reason=0]",
                        "10-08 13:06:22.280 - Event [IFNAME=wlan0 CTRL-EVENT-SCAN-STARTED ]",
                        "10-08 13:06:25.363 - Event [IFNAME=wlan0 CTRL-EVENT-SCAN-STARTED ]",
                        "10-08 13:08:15.018 - Event [IFNAME=wlan0 CTRL-EVENT-DISCONNECTED "
                                + "bssid=9c:1c:12:e8:72:d2 reason=3 locally_generated=1]",
                        "10-08 13:08:15.324 - wlan0: 442:IFNAME=wlan0 ENABLE_NETWORK 0 -> true");

        DumpsysItem dumpsys = new DumpsysParser().parse(inputBlock);
        assertNotNull(dumpsys.getBatteryStats());
        assertNotNull(dumpsys.getPackageStats());
        assertNotNull(dumpsys.getProcStats());
        assertNotNull(dumpsys.getWifiStats());
    }
}
