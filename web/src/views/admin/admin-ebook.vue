<template>
  <a-layout>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <a-table
          :columns="columns"
          :row-key="record => record.id"
          :data-source="ebooks"
          :pagination="pagination"
          :loading="loading"
          @change="handleTableChange"
      >
        <template #cover="{ text: cover }">
          <img v-if="cover" :src="cover" alt="avatar" />
        </template>
        <template v-slot:action="{ text, record }">
          <a-space size="small">
            <a-button type="primary" @click="handleEdit">
              编辑
            </a-button>
            <a-modal v-model:open="open" title="编辑电子书" :confirm-loading="confirmLoading" @ok="handleSave">
              <p>{{ modalText }}</p>
            </a-modal>
            <a-button type="danger">
              删除
            </a-button>
          </a-space>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts" setup>
import {onMounted, ref} from 'vue';
import axios from 'axios';

const ebooks = ref();
const pagination = ref({
  current: 1,
  pageSize: 4,
  total: 0
});
const loading = ref(false);

const columns = [
{
  title: '封面',
  dataIndex: 'cover',
  slots: {customRender: 'cover'}
},
{
  title: '名称',
  dataIndex: 'name'
},
{
  title: '分类一',
  key: 'category1Id',
  dataIndex: 'category1Id'
},
{
  title: '分类二',
  dataIndex: 'category2Id'
},
{
  title: '文档数',
  dataIndex: 'docCount'
},
{
  title: '阅读数',
  dataIndex: 'viewCount'
},
{
  title: '点赞数',
  dataIndex: 'voteCount'
},
{
  title: 'Action',
  key: 'action',
  slots: {customRender: 'action'}
}
];

/**
* 数据查询
**/
const handleQuery = (params: any) => {
loading.value = true;
axios.get("/ebook/list", {
  params: {
    pageNum: params.page,
    pageSize: params.size
  }
}).then((response) => {
    loading.value = false;
    const data = response.data;
    ebooks.value = data.content.list;

    // 重置分页按钮
    pagination.value.current = params.pageNum;
    pagination.value.total = data.content.total;
  });
};

/**
* 表格点击页码时触发
*/
const handleTableChange = (pagination: any) => {
  console.log("看看自带的分页参数都有啥：" + pagination.current);
  handleQuery({
    page: pagination.current,
    size: pagination.pageSize
  });
};

/**
* 弹出编辑框
*/
const open = ref<boolean>(false);
const handleEdit = () => {
  open.value = true;
};

/**
 * 处理保存
 */
const modalText = ref<string>('Content of the modal');
const confirmLoading = ref<boolean>(false);
const handleSave = () => {
  confirmLoading.value = true;
  setTimeout(() => {
    open.value = false;
    confirmLoading.value = false;
  }, 2000);
};

onMounted(() => {
handleQuery({
    page: pagination.value.current,
    size: pagination.value.pageSize,
  });
});
</script>

<style scoped>
img {
  width: 50px;
  height: 50px;
}
</style>
