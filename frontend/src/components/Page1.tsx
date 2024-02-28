import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useForm } from 'react-hook-form';
import { useDispatch } from 'react-redux';
import { setOrderData } from '../redux/orderSlice';
import { TextField, Button } from '@mui/material'; // Import MUI components

const Page1 = () => {
  const { register, handleSubmit, formState: { errors } } = useForm({ mode: 'all' }); // Set validation mode to 'all'
  const dispatch = useDispatch();
  const navigate = useNavigate();

  const onSubmit = (data) => {
    dispatch(setOrderData(data));
    navigate('/page2');
  };

  return (
    <div>
      <form onSubmit={handleSubmit(onSubmit)}>
        <TextField // Use Material UI TextField
          label="Наименование товара"
          {...register('productName', { required: true })} // Mark field as required
          margin="normal"
          fullWidth
          error={!!errors.productName} // Set error state based on validation
          helperText={errors.productName?.message || 'Поле обязательно для заполнения'} // Display error message
        />
        <TextField // Use Material UI TextField
          label="Кол-во товара"
          type="number"
          {...register('productCount', { required: true, min: 1 })} // Mark field as required and set minimum value
          margin="normal"
          fullWidth
          error={!!errors.productCount} // Set error state based on validation
          helperText={errors.productCount?.message || 'Поле должно быть числом, минимум 1'} // Display error message
        />
        <TextField // Use Material UI TextField
          label="Оплаченная сумма"
          type="number"
          {...register('price', { required: true, min: 0 })} // Mark field as required and set minimum value
          margin="normal"
          fullWidth
          error={!!errors.price} // Set error state based on validation
          helperText={errors.price?.message || 'Поле должно быть числом, минимум 0'} // Display error message
        />
        <Button // Use Material UI Button
          type="submit"
          variant="contained"
          sx={{ mt: 3 }}
          disabled={!!Object.keys(errors).length} // Disable button if any errors exist
        >
          Создать заказ
        </Button>
      </form>
    </div>
  );
};

export default Page1;
