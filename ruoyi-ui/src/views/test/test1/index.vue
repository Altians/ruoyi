<template>
<div>
  <el-button @click="add">新增</el-button>
  <el-button @click="deleteAll">删除</el-button>
  <el-table :data="list" stripe style="width: 100%"  @selection-change="handleSelectionChange">
    <el-table-column type="selection" width="55" />
    <el-table-column prop="name" label="姓名" width="180" />
    <el-table-column prop="gender" label="性别" width="180" />
    <el-table-column prop="phone" label="电话号码" />
    <el-table-column prop="" label="操作" >
      <template #default="scope">

      <el-button @click.stop="handleEdit(scope.row)">编辑</el-button>
      <el-button  @click.stop="deleteIt(scope.row)">删除</el-button>
      </template>
    </el-table-column >
  </el-table>
<!--  表单-->
  <el-dialog :title="title"  v-model="open" center :close-on-click-modal="false"
             :destroy-on-close="true"  >
    <el-form   :model="ruleForm"   ref="ruleFormRef" >
                <el-form-item label="姓名" prop="name">
                  <el-input v-model="ruleForm.name" :value="ruleForm.name"></el-input>
                </el-form-item>
      <el-form-item label="性别" prop="gender">
        <el-input v-model="ruleForm.gender" :value="ruleForm.gender"></el-input>
      </el-form-item>
      <el-form-item label="电话号码" prop="phone">
        <el-input  v-model="ruleForm.phone" :value="ruleForm.phone"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button >取 消</el-button>
      <el-button type="primary" @click="submitForm">确 定</el-button>
    </div>
  </el-dialog>
</div>
</template>

<script setup>
import {ref,onMounted, unref} from "vue";
import {addItem, deleteItem, edit, queryId, test1,deleteItems} from "@/api/api/user";
let pId =ref(null)
onMounted(()=>{
  getList()
  console.log('test',unref(test))
})
 const queryParams = ref({
   off:1,
   num:10,
   name:null
 })
const test = ref(0)

let ruleForm = ref({
  phone:null,
  name:null,
  gender:null,
  id:null
})
const multipleSelection = ref([])
let title=ref("修改")
let open = ref(false)
let list = ref([])
 function getList(){
   test1(queryParams.value).then((res)=>{
     console.log('查询结果',res)
      list.value =  res.rows
   })
 }
 //编辑
 function  handleEdit (row){
   console.log('row',row.id)
   title = "修改"
   pId = row.id
   queryId(pId).then((res)=>{
     open.value = true
     ruleForm.value = res
     console.log('查询的id数据',res,ruleForm)
   })
 }
 //提交
 function submitForm() {

   if (ruleForm.value.id != null) {
     edit(ruleForm.value).then(res => {
       open.value = false;
       console.log('更新', res)
       getList();
     })
   } else {
     addItem(ruleForm.value).then(res=>{
       open.value = false
       console.log('新增', res)
       getList();
     })
   }
 }
//表单重置
function  reset (){
  ruleForm = ref( {
    phone:null,
    name:null,
    gender:null,
    id:null
  })
}
//新增
function add (){
  reset()
  title = "新增"
  open.value = true
}
//删除
function  deleteIt(row){
  deleteItem(row.id).then(res=>{
    console.log('删除成功',row.id,res)
    getList()
  })
}
//批量删除
function  deleteAll (){
  deleteItems(multipleSelection.value).then(res=>{
    console.log('删除成功',res)
    getList()
  })
}
const handleSelectionChange = (val) => {
  multipleSelection.value= []
  val.forEach((item)=>{
    multipleSelection.value.push(item.id)
  })

  console.log('选择',multipleSelection.value)
}
</script>

<style scoped>

</style>