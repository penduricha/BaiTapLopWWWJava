<script>
import thucAnService from "@/service/ThucAnService.js";
export default {
  name:'App',
  created() {
    this.fetchListThucAn();
  },
  data(){
    return{
      listThucAn:null,
      tenThucAnInput:'',
      diaChiInput:'',
      giaVonInput:'',
      loaiInput:'',
      nhaCungCapInput:'',
      selectedThucAn:null,

    }
  },
  methods:{
    async fetchListThucAn(){
        await thucAnService.getThucAns().then(response => {
          this.listThucAn = response.data;
          console.log(this.listThucAn);
        }).catch(error => {
          console.error(error);
        });
    },
    selectThucAn(thucAn){
      this.selectedThucAn=thucAn;
      this.tenThucAnInput=thucAn.tenThucAn;
      this.diaChiInput=thucAn.diaChi;
      this.giaVonInput=thucAn.giaVon;
      this.loaiInput=thucAn.loai;
      this.nhaCungCapInput=thucAn.nhaCungCap;
    },
    async addThucAn(){
      // this.tenThucAnInput='';
      // this.diaChiInput='';
      // this.giaVonInput='';
      // this.loaiInput='';
      // this.nhaCungCapInput='';
      if(!this.tenThucAnInput||
          !this.diaChiInput||
          !this.giaVonInput||
          !this.loaiInput||
          !this.nhaCungCapInput
      ){
        alert("Field can't be empty.")
      }else{
        const newThucAn = {
          //nho +1 nha ong gia
          id: Math.max(...this.listThucAn.map(t => t.id))+1,
          tenThucAn: this.tenThucAnInput,
          diaChi: this.diaChiInput,
          giaVon: this.giaVonInput,
          loai: this.loaiInput,
          nhaCungCap: this.nhaCungCapInput,
        };
        try {
          await thucAnService.createThucAn(newThucAn);
          alert('Successfully!')
          this.resetField();
          await this.fetchListThucAn();
        } catch (error) {
          console.error('Error creating:', error)
          alert('Error creating. Please try again.')
        }
      }
    },
    resetField(){
      this.tenThucAnInput='';
      this.diaChiInput='';
      this.giaVonInput='';
      this.loaiInput='';
      this.nhaCungCapInput='';
    },
    async deleteData(thucAn){
      try {
        await thucAnService.deleteThucAnById(thucAn.id);
        alert('Delete successfully!');
        await this.fetchListThucAn();
      } catch (error) {
        console.error('Error creating:', error)
        alert('Error Please try again.')
      }
    },

    async updateThucAn(){
      if(!this.tenThucAnInput||
          !this.diaChiInput||
          !this.giaVonInput||
          !this.loaiInput||
          !this.nhaCungCapInput
      ){
        alert("Field can't be empty.")
      }else{
        const newThucAn = {
          //nho +1 nha ong gia
          id: this.selectedThucAn.id,
          tenThucAn: this.tenThucAnInput,
          diaChi: this.diaChiInput,
          giaVon: this.giaVonInput,
          loai: this.loaiInput,
          nhaCungCap: this.nhaCungCapInput,
        };
        try {
          await thucAnService.putThucAnById(this.selectedThucAn.id,newThucAn);
          alert('Update successfully!');
          this.resetField();
          await this.fetchListThucAn();
        } catch (error) {
          console.error('Error creating:', error)
          alert('Error Please try again.')
        }
      }
    }
  },
}
</script>
<template>
  <div class="my-container">
    <div style="border-left-style: solid;
      border-right-style: solid;
      border-top-style: solid;
      width: 500px;
      height: 600px">
      <h5 class="mb-4" style="text-align: center">Final 21107601 Tu Quang Nhat</h5>
      <form class="border rounded p-4">
        <div class="form-group">
          <label >Ten thuc an:</label>
          <input type="text" class="form-control" v-model="tenThucAnInput" required>
        </div>
        <div class="form-group">
          <label >Dia Chi:</label>
          <input type="text" class="form-control" v-model="diaChiInput" required>
        </div>
        <div class="form-group">
          <label >Gia von:</label>
          <input type="number" class="form-control" v-model="giaVonInput" required>
        </div>
        <div class="form-group">
          <label >Loai:</label>
          <input type="text" class="form-control" v-model="loaiInput" required>
        </div>
        <div class="form-group">
          <label >Nha cung cap:</label>
          <input type="text" class="form-control" v-model="nhaCungCapInput" required>
        </div>
      </form>
      <button class="btn btn-primary" @click="addThucAn" style="margin-left: 30px">Add</button>
      <button class="btn btn-primary" @click="updateThucAn" style="margin-left: 10px">Update</button>

    </div>
    <div style="border-style: solid; width: 1000px; height: 500px">
      <table class="table table-striped table-bordered">
        <thead>
        <tr>
          <th>Ma thuc an</th>
          <th>Ten thuc an</th>
          <th>Dia chi</th>
          <th>Gia von</th>
          <th>Loai</th>
          <th>Nha cung cap</th>
          <th>Chon</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(thucAn) in listThucAn"
            :class="{ 'selected': selectedThucAn === thucAn }"
            @click="selectThucAn(thucAn)"
        >
          <td style="border-style: solid">{{thucAn.id}}</td>
          <td style="border-style: solid">{{thucAn.tenThucAn}}</td>
          <td style="border-style: solid">{{thucAn.diaChi}}</td>
          <td style="border-style: solid">{{thucAn.giaVon}}</td>
          <td style="border-style: solid">{{thucAn.loai}}</td>
          <td style="border-style: solid">{{thucAn.nhaCungCap}}</td>
          <td style="border-style: solid">
            <button class="btn btn-danger" @click="deleteData(thucAn)">Delete</button>
          </td>
        </tr>

        </tbody>
      </table>
    </div>

  </div>
</template>
<style>
.my-container {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 1000px;
  height: 1000px;
  margin-left: 70px;
  background-color: #f5f5f5;
  padding: 2rem;
  box-sizing: border-box;
  border-style: solid;
}
.selected {
  background-color: #e6f2ff; /* Màu nền của hàng được chọn */
  font-weight: bold; /* Định dạng chữ in đậm */
  color: #0066cc; /* Màu chữ của hàng được chọn */
}
</style>