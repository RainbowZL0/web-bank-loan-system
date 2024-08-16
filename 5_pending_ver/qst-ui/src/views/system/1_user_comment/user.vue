<template>
  <div style="text-align: center; margin: 0 auto; width: 80%;">
    <el-form ref="message_form" :model="form" label-width="120px">
      <h1 style="font-size: 2rem; margin-bottom: 1rem;">留言板</h1>

      <el-form-item label="留言内容" prop="messageContent" style="margin-bottom: 1rem;">
        <el-input
          type="textarea"
          v-model="form.messageContent"
          style="width: 80%; border: 2px solid #42b983;"
          placeholder="请在此输入您的留言..."
          :rows="4"
        />
      </el-form-item>

      <!-- 错误消息显示 -->
      <div v-if="errorMessage">
        <p style="color: red;">{{ errorMessage }}</p>
      </div>

      <el-button @click="clearForm" style="margin-right: 1rem;">清空</el-button>
      <el-button type="primary" @click="submitMessage" style="background-color: #42b983; border-color: #42b983;">提交</el-button>
    </el-form>
  </div>
</template>

<script>
import axios from 'axios'
import {submit_comment} from "@/api/system/1_user_comment";
import { Message } from 'element-ui';
import { insertAptitude } from '@/api/system/loanschart'

export default {
  name: "MessageBoard",
  data() {
    return {
      user_name: "",
      form: {
        userId: 0,  // 此处随意填写一个数字，后端会通过user_name查找id
        messageContent: ""
      },
      errorMessage: "", // 用于存储错误消息的字段
    };
  },
  methods: {
    async submitMessage() {
      // 在提交之前先进行检查
      if (this.form.messageContent.trim()) {
        try {
          const dataToSend = {
            comment_id: 0,
            user_id: this.form.userId,
            comment_content: this.form.messageContent
          };

          await submit_comment(this.user_name, dataToSend).then(response => {
            if (response) {
              // response不为空，说明提交成功
              console.log('Server Response:', response);
              this.errorMessage = '';
              Message.success('提交成功');
            } else {
              // response为空，说明提交失败，控制台打印回应的错误信息
              console.log(response)
            }
          })

        } catch (error) {
          console.error('Error:', error);
          this.errorMessage = "提交失败，请重试。";
        }
      } else {
        this.errorMessage = "留言内容不能为空";
      }
    },
    clearForm() {
      this.form.messageContent = "";
      this.errorMessage = ""; // 清空错误消息
    },
    // 检查字段的有效性
    checkFields() {
      this.errorMessage = ""; // 先清空旧的错误消息
      if (!this.form.messageContent.trim()) {
        this.errorMessage = "留言内容不能为空";
        return false;
      }
      return true; // 如果所有检查都通过了，返回 true
    },
    getUsername(){
      const match = document.cookie.match(new RegExp('(^| )' + 'username' + '=([^;]+)'))
      return match ? match[2] : undefined
    },
    saveUsername(){
      this.user_name = this.getUsername()
      console.log('Username获取成功：', this.user_name)
    }
  },
  created() {
    this.saveUsername()
  }
};
</script>
