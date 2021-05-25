import React, { useState,useEffect} from "react";
import "./App.css";
import "antd/dist/antd.css";
import Axios from 'axios';
import { Form, Input, Button, Row, Col, DatePicker, Select, Radio } from "antd";
import { render } from "@testing-library/react";
const { Option } = Select;
function App() {
  const [details,setDetails]=useState([]);

  useEffect(()=>{
    fetch('http://localhost:8077/abcSchool/getAllAdmInfo')
    .then(res=>res.json())
    .then(res=>{
      setDetails(res);
    }).catch(e=>{
      console.log(e);
    })
  });
  const url="http://localhost:8077/abcSchool/saveAdmInfo"
  const[data,setData]=useState({
    name:"",
    dob:"",
    std:"",
    division:"",
    gender:""
  })
// function submit(e){
//   e.preventDefault();
//   Axios.post(url,{
//     name=data.name,
//     dob=data.dob,
//     std=data.std,
//     division=data.division,
//     gender=data.gender
//   })
//   .then(res=>{
//     console.log(res.data)
//   })
// }
  function handle(e){
    const newData={...data}
    newData[e.target.id]=e.target.value
    setData(newData)
    console.log(newData)
  }

  return (
    <div className="App" style={{ padding: "60px", paddingLeft: "640px" }}>
      <Form>
        <Row>
          <Col xl={8}>
            <label>Name</label>
            <Form.Item
              name="name"
              rules={[{ required: true, message: "Enter your name" }]}
            onChange={(e)=>handle(e)} id="name" value="data.name">
              <Input />
            </Form.Item>
          </Col>
        </Row>
        <br />
        <Row>
          <Col xl={8}>
            <label>Date Of Birth</label>
            <Form.Item
              name="Dob"
              rules={[{ required: true, message: "Enter your Dob" }]}
            onChange={(e)=>handle(e)} id="dob" value="data.dob">
              <DatePicker />
            </Form.Item>
          </Col>
        </Row>
        <br />
        <Row>
          <Col xl={8}>
            <label>Class</label>
            <Form.Item
              name="class"
              rules={[{ required: true, message: "Choose your class" }]}
            onChange={(e)=>handle(e)} id="std" value="data.std">
              <Select>
                <Option value="I">I</Option>
                <Option value="II">II</Option>
                <Option value="III">III</Option>
                <Option value="IV">IV</Option>
                <Option value="V">V</Option>
                <Option value="VI">VI</Option>
                <Option value="VII">VII</Option>
                <Option value="VIII">VIII</Option>
                <Option value="IX">IX</Option>
                <Option value="X">X</Option>
                <Option value="X11">X11</Option>
                <Option value="X12">X12</Option>
              </Select>
            </Form.Item>
          </Col>
        </Row>
        <br />
        <Row>
          <Col xl={8}>
            <label>Standard</label>
            <Form.Item
              name="Standard"
              rules={[{ required: true, message: "Choose your Standard" }]}
            onChange={(e)=>handle(e)} id="division" value="data.division">
              <Select>
                <Option value="A">A</Option>
                <Option value="B">B</Option>
                <Option value="C">C</Option>
              </Select>
            </Form.Item>
          </Col>
        </Row>
        <br />
        <Row>
          <Col xl={8}>
            <label>Gender</label>
            <Form.Item
              name="Gender"
              rules={[{ required: true, message: "Choose your Gender" }]}
            onChange={(e)=>handle(e)} id="gender" value="data.gender">
              <Radio.Group>
                <Radio value="Male">Male</Radio>
                <Radio value="Female">Female</Radio>
              </Radio.Group>
            </Form.Item>
          </Col>
        </Row>
        <br />
        <Row>
          <Col xl={8}>
            <Form.Item>
              <Button type="primary" htmlType="submit">
                Submit
              </Button>
            </Form.Item>
          </Col>
        </Row>
      </Form>
      {/* details:{details.length} */}
      <table>
        <thead>
        <tr>
          <td>name</td>
          <td>dob</td>
          <td>std</td>
          <td>division</td>
          <td>gender</td> 
        </tr>
        </thead>
        <tbody>
          {details.map((p,index)=>{
            return<Tr key={index} details={p}/>
          })}
        </tbody>
      </table>

    </div>

  );
}
const Tr=({details})=>{
  return(
    <tr>
      <td>{details.name}</td>
      <td>{details.dob}</td>
      <td>{details.std}</td>
      <td>{details.division}</td>
      <td>{details.gender}</td>
    </tr>

  )
}

export default App;
