-- BPM模块：
-- 流程管理：管理流程定义、流程实例和流程任务，支持流程的创建、启动、流转和完成等操作。
-- 流程节点：管理流程中的各个节点，包括审核、审批、修改、查看等不同类型的节点。
-- 条件分支：记录流程节点审核前、审核后和审核中的操作数据，用于流程审核路径的灵活控制。
-- 流程池：管理流程的状态，包括流转中、历史流程和废弃流程。
-- 表单与流程关联：建立流程与固定表单的关联关系，用于流程流转过程中收集表单数据。

-- 其他关联的六个模块：
-- 组织架构模块：管理企业的组织结构，包括集团、公司、部门和岗位等信息。
-- 商业公司管理模块：管理商业公司的信息，包括商业公司的增删改查。
-- 收付款模块：管理收款和付款流水，包括收款和付款的增删改查。
-- 库存管理模块：管理向商业公司发货的数量和货物单价，包括发货数据的增删改查。
-- 流向管理模块：管理货物的流向，包括货物流向的增查操作。
-- 权限模块：设置组织架构中的人员账号是否具有系统中某个操作的权限。

-- 流程节点具有两个状态：操作中和操作后
-- 在操作中的状态中，有不同的操作供操作人选择，如审核、审批、加签、知会、移交、不同意和终止。
-- 在操作后的状态中，开始执行条件分支功能中的分支逻辑，以确定下一个流程节点可以执行哪些操作中的操作。

drop table if exists by_approval_process;
create table by_approval_process(
process_id int primary key auto_increment COMMENT'主键',
process_name varchar(50) not null COMMENT'流程名称',
process_code varchar(50) COMMENT'流程编码',
process_table_code varchar(50) COMMENT'表单关联信息',
`status` int not null COMMENT'状态：1.启用 2.停用 3.废弃',
creator_userId int not null COMMENT '创建人信息',
creator_time datetime not null COMMENT '创建时间',
updater_id int COMMENT'更新人',
update_time datetime COMMENT'更新时间'
)COMMENT'业务流程表';

drop table if exists by_process_node;
create table by_process_node(
process_node_id int primary key auto_increment COMMENT'主键',
process_code varchar(50) COMMENT'流程编码',
node_name varchar(50) COMMENT'流程节点名称',-- 可忽略
node_code varchar(50) COMMENT'流程节点编码',
node_step INT COMMENT'流程节点顺序',
node_step_status int COMMENT'节点顺序属性：1.空节点跳过 2.空节点由当前操作人指定下一个节点审核人',
node_status int COMMENT'节点执行方式：1.全部执行 2.有竞争执行 3.由上一个操作人指定下一个节点审核人',
node_function varchar(50) COMMENT'节点属性：发起、审核、审批、知会、通知',
condition_code varchar(50) COMMENT'分支编码',
`status` int not null COMMENT'状态：1.启用 2.停用 3.删除',
creator_userId not null int COMMENT '创建人id',
creator_time datetime not null COMMENT '创建时间',
updater_id int COMMENT '更新人',
update_time datetime COMMENT'更新时间'
)COMMENT'流程节点表';

drop table if exists by_process_log;
create table by_process_log(
)COMMENT'流程操作日志表';

drop table if exists by_process_table;
create table by_process_table(
table_code varchar(50) COMMENT'表单编码',
process_code varchar(50) COMMENT'流程编码',
node_code varchar(50) COMMENT'流程节点编码'
)COMMENT'流程-表单关联表';

-- 流程角色表：用于记录账户在流程节点中具有审核、审批、修改和查看功能的权限设置
drop table if exists by_process_node_role;
create table by_process_node_role(
role_id int primary key auto_increment COMMENT'主键',
role_code varchar(50) COMMENT'角色编码',
node_code varchar(50) COMMENT'流程节点编码',
role_permission int COMMENT'操作权限：审核、审批、修改和查看'
)COMMENT'流程角色表';

drop table if exists by_proccess_node_role_user;
create table by_proccess_node_role_user(
role_id int COMMENT'角色id',
user_id int COMMENT'用户id'
)COMMENT'流程角色-用户关联表';

drop table if exists by_process_branch;
create table by_process_branch(
id int PRIMARY key COMMENT'主键',
process_code varchar(50) COMMENT'流程编码',
branch_name varchar(50) COMMENT'分支名称', -- 可忽略
branch_code varchar(50) COMMENT'分支编码',
condition_code varchar(50) COMMENT'条件编码',
branch_step int COMMENT'执行步骤'
)COMMENT'流程分支表';

create table by_process_branch_node;
create table by_process_branch_node(
id int PRIMARY key COMMENT'主键',
process_code varchar(50) COMMENT'流程编码',
node_code varchar(50) COMMENT'节点编码',
node_name varchar(50) COMMENT'节点名称',
node_step int COMMENT'分支中流程节点的顺序'
)COMMENT'分支-节点关联顺序表';

drop table if exists by_process_branch_conditions;
create table by_process_branch_conditions(
condition_id int PRIMARY key COMMENT'主键',
process_code varchar(50) COMMENT'流程编码',
node_code varchar(50) COMMENT'分支流程节点编码',
node_step int COMMENT'流程节点顺序',
role_code varchar(50) COMMENT'角色编码',
branch_code varchar(50) COMMENT'分支编码',
condition_code varchar(50) COMMENT'条件编码',
-- condition_table_code varchar(50) COMMENT'分支条件字段表编码',
-- condition_column_code varchar(50) COMMENT'分支条件字段编码',
condition_compare_before_value varchar(50) COMMENT'需要比较的值',
condition_compare varchar(50) COMMENT'比较条件',
condition_compare_target_value varchar(50) COMMENT'比较的目标值',
condition_compare_formula varchar(50) COMMENT'比较公式',
`status` int not null COMMENT'状态：1.启用 2.停用 3.删除',
creator_id int COMMENT'创建人信息',
create_time datetime COMMENT'创建时间',
updater_id int COMMENT'更新人信息',
update_time datetime COMMENT'更新时间'
)COMMENT'流程分支条件表';

drop table if exists by_process_ongoing;
create table by_process_ongoing(
process_id int PRIMARY KEY auto_increment COMMENT'主键',
process_code varchar(50) COMMENT'流程编码',
node_code varchar(50) COMMENT'节点编码',
node_step int COMMENT'节点顺序步骤',
condition_code varchar(50) COMMENT'分支编码',
form_code varchar(50) COMMENT'审核编号',
table_code varchar(50) COMMENT'表单编号',
assignee_name varchar(255) COMMENT'当前待办人',
node_step_status int COMMENT'节点属性类型：1.空节点跳过 2.空节点由当前操作人指定下一个节点审核人',
arrival_time datetime COMMENT'流程到达该节点的起始时间',
creator_id int COMMENT'发起人信息',
create_time datetime COMMENT'发起时间'
)COMMENT'流程池-流转中';

drop table if exists by_process_ongoing_log;
create table by_process_ongoing_log(
log_id int PRIMARY KEY auto_increment COMMENT'主键',
process_code varchar(50) COMMENT'流程编码',
node_code varchar(50) COMMENT'节点编码',
node_step int COMMENT'节点顺序步骤',
condition_code varchar(50) COMMENT'分支编码',
form_code varchar(50) COMMENT'审核编号',
table_name varchar(50) COMMENT'表单名称',
table_code varchar(50) COMMENT'表单编号',
assignee_name varchar(255) COMMENT'当前待办人',
node_step_status int COMMENT'节点属性类型：1.空节点跳过 2.空节点由当前操作人指定下一个节点审核人',
arrival_time datetime COMMENT'流程到达该节点的起始时间',
audit_time datetime COMMENT'审核时间',
review_stay_time datetime COMMENT'审核用时时间',
node_result varchar(50) COMMENT'审核结果',
creator_id int COMMENT'发起人信息',
create_time datetime COMMENT'发起时间',
updater_id int COMMENT'更新人信息',
update_time datetime COMMENT'更新时间'
)COMMENT'流程池-流转日志';

drop table if exists by_process_historical;
create table by_process_historical(
process_id int PRIMARY KEY auto_increment COMMENT'主键',
process_code varchar(50) COMMENT'流程编码',
node_code varchar(50) COMMENT'节点编码',
form_code varchar(50) COMMENT'审核编号',
table_code varchar(50) COMMENT'表单编号',
creator_id int COMMENT'发起人信息',
create_time datetime COMMENT'发起时间'
)COMMENT'流程池-历史流程';

drop table if exists by_process_discarded;
create table by_process_discarded(
process_id int PRIMARY KEY auto_increment COMMENT'主键',
process_code varchar(50) COMMENT'流程编码',
form_code varchar(50) COMMENT'审核编号',
table_code varchar(50) COMMENT'表单编号',
creator_id int COMMENT'发起人信息',
create_time datetime COMMENT'发起时间',
discarded_time datetime COMMENT'终止时间',
discarded_reason varchar(200) COMMENT'终止原因'
)COMMENT'流程池-终止流程';

-- 动态表单生成相关的业务表;
drop table if exists by_process_discarded;
create table by_process_mapping(
process_id int PRIMARY KEY auto_increment COMMENT'主键',
)COMMENT'表单关联流程表';
