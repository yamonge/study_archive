#ifndef API_CLIENT_H
#define API_CLIENT_H

#include <stdbool.h>

/* 원본 C#의 Models/WorkOrderDto.cs 대응 */
typedef struct {
    long id;
    char product_code[64];
    int target_qty;
    int current_qty;
    char status[32];
} WorkOrder;

/* 원본 C#의 Models/ProductionReportDto.cs 대응 */
typedef struct {
    long order_id;
    char machine_id[64];
    char serial_no[128];
    char result[8];       /* "OK" 또는 "NG" */
    char defect_code[32]; /* 없으면 빈 문자열 */
} ProductionReport;

/* libcurl 전역 초기화/정리. 프로그램 시작/종료 시 한 번씩만 호출 */
int api_client_init(void);
void api_client_cleanup(void);

/* 작업 지시 폴링.
 * 반환값: 할당된 작업이 있으면 true(out에 채움), 없거나 통신 실패면 false */
bool api_poll_work_order(const char *base_url, const char *machine_id, WorkOrder *out);

/* 생산 실적 보고.
 * 반환값(정적 문자열): "OK" | "SHORTAGE" | "SERVER_ERROR" | "NETWORK_ERROR" */
const char *api_report_production(const char *base_url, const ProductionReport *report);

#endif /* API_CLIENT_H */