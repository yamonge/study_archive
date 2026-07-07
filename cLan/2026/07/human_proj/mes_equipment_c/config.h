#ifndef CONFIG_H
#define CONFIG_H

/* 원본 C#의 Config/AppConfig.cs에 대응 */

#define BASE_URL "http://localhost:8111/"
#define MACHINE_ID "LINE-01-M01"
#define POLLING_INTERVAL_MS 5000

/* 원본에서는 MachineSimulator.cs에 하드코딩되어 있더 값들.
 * C 포팅에서는 그대로 유지하되 한 파일(config.h)로 모아 정리했다. */
#define L1_IP "127.0.0.1"
#define L1_PORT 5006

#endif /* CONFIG_H */